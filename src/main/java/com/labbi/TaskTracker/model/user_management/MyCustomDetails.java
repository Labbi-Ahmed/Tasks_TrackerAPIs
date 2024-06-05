package com.labbi.TaskTracker.model.user_management;

import com.labbi.TaskTracker.repogitory.user_management.UserRepogitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyCustomDetails implements UserDetailsService {

    @Autowired
    private UserRepogitory repogitory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<com.labbi.TaskTracker.model.user_management.User> optionalUser = Optional.ofNullable(repogitory.findByEmail(username));

        if(optionalUser.isPresent()){

            var userObject = optionalUser.get();
            return User.builder()
                    .username(userObject.getEmail())
                    .password(userObject.getPassword())
                    .roles(userObject.getRoles().toString())
                    .build();
        }
        else
            throw new UsernameNotFoundException(username);
    }
}
