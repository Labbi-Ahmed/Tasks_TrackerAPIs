package com.labbi.TaskTracker.controller.user_management;

import com.labbi.TaskTracker.model.user_management.dao.UserDAO;
import com.labbi.TaskTracker.model.user_management.dao.UserLoginDAO;
import com.labbi.TaskTracker.service.user_management.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> registerNewUser(@Valid @RequestBody UserDAO userDAO){
        if(userService.findUserByEmail(userDAO.getEmail()) != null)
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email Address already used");

        if(!userDAO.getPassword().equals(userDAO.getConfirmPassword()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password must ne matched with confirm password");

        userService.createNewUser(userDAO);

        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully Register user");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> loginUser(@Valid @RequestBody UserLoginDAO dao){

        SecurityContext context = SecurityContextHolder.createEmptyContext();

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dao.getEmail(),dao.getPassword())
        );

        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);

        return ResponseEntity.status(HttpStatus.OK).body("Successfully Login!");


    }




}
