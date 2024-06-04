package com.labbi.TaskTracker.model;

import com.labbi.TaskTracker.repogitory.UserRepogitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyCustomDetails implements UserDetailsService {

    @Autowired
    private UserRepogitory repogitory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<com.labbi.TaskTracker.model.User> optionalUser = Optional.ofNullable(repogitory.findByEmail(username));

        if(optionalUser.isPresent()){

            var userObject = optionalUser.get();
            System.out.println(userObject.getPassword());
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
