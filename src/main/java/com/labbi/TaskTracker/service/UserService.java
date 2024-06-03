package com.labbi.TaskTracker.service;

import com.labbi.TaskTracker.common.ObjectMapper;
import com.labbi.TaskTracker.dao.UpdateUserDAO;
import com.labbi.TaskTracker.dao.UpdateUserPasswordDAO;
import com.labbi.TaskTracker.dao.UserDAO;
import com.labbi.TaskTracker.dao.UserLoginDAO;
import com.labbi.TaskTracker.dto.UserDTO;
import com.labbi.TaskTracker.model.Role;
import com.labbi.TaskTracker.model.User;
import com.labbi.TaskTracker.repogitory.RoleRepository;
import com.labbi.TaskTracker.repogitory.UserRepogitory;
import com.labbi.TaskTracker.utility.InternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepogitory repogitory;

    private final RoleRepository roleRepository;

    public User findUserByEmail(String email) {
        return repogitory.findByEmail(email);
    }

    public User createNewUser(UserDAO dao) {

        User user = ObjectMapper.createUserMapper(dao);

        Role defaultRole = roleRepository.findByName("USER");
        Set<Role> roles = new HashSet<>();
        roles.add(defaultRole);

        user.setRoles(roles);

        return  repogitory.save(user);


    }

    public User getLoginUser(UserLoginDAO dao) {

        String password = InternalService.encodePassword(dao.getPassword());
        return repogitory.findByEmailAndPassword(dao.getEmail(), password);
    }

    public UserDTO userProfileEdit(UpdateUserDAO dao , String email) {

        User user = repogitory.findByEmail(email);
        System.out.println(user);
        user = ObjectMapper.updateUserMapper(user,dao);

        user = repogitory.save(user);
        UserDTO userDTO = new UserDTO(user);

        return userDTO;
    }

    public String changePassword(UpdateUserPasswordDAO dao, String email) {

        String password = InternalService.encodePassword(dao.getOldPassword());

        User user = repogitory.findByEmailAndPassword(email,password);

        if(user == null) return "Invalid email or current password";

        if(!dao.getNewPassword().equals(dao.getNewConfirmPassword())) return "Password not matched";

        user.setPassword(InternalService.encodePassword(dao.getNewConfirmPassword()));

        repogitory.save(user);

        return "Successfully changed password";
    }
}
