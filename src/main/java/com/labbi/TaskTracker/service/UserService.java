package com.labbi.TaskTracker.service;

import com.labbi.TaskTracker.common.ObjectMapper;
import com.labbi.TaskTracker.model.dao.UpdateUserDAO;
import com.labbi.TaskTracker.model.dao.UpdateUserPasswordDAO;
import com.labbi.TaskTracker.model.dao.UserDAO;
import com.labbi.TaskTracker.model.dao.UserLoginDAO;
import com.labbi.TaskTracker.model.dto.UserDTO;
import com.labbi.TaskTracker.model.Role;
import com.labbi.TaskTracker.model.User;
import com.labbi.TaskTracker.repogitory.RoleRepository;
import com.labbi.TaskTracker.repogitory.UserRepogitory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepogitory repogitory;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public User findUserByEmail(String email) {
        return repogitory.findByEmail(email);
    }

    public User createNewUser(UserDAO dao) {

        dao.setPassword(passwordEncoder.encode(dao.getPassword()));

        User user = ObjectMapper.createUserMapper(dao);



        Role defaultRole = roleRepository.findByName("USER");
        Set<Role> roles = new HashSet<>();
        roles.add(defaultRole);

        user.setRoles(roles);

        return  repogitory.save(user);


    }

    public User getLoginUser(UserLoginDAO dao) {

        String password = passwordEncoder.encode(dao.getPassword());
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

        if(!dao.getNewPassword().equals(dao.getNewConfirmPassword())) return "Password not matched";

        User user = repogitory.findByEmail(email);

        if(user == null) return "Invalid email or current password";

        if(!passwordEncoder.matches(dao.getOldPassword(), user.getPassword())) return "Password Invalid";
        user.setPassword(passwordEncoder.encode(dao.getNewConfirmPassword()));

        repogitory.save(user);

        return "Successfully changed password";
    }
}
