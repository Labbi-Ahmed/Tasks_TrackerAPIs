package com.labbi.TaskTracker.controller;

import com.labbi.TaskTracker.customException.EmailAlreadyExistException;
import com.labbi.TaskTracker.customException.EmailNotRegister;
import com.labbi.TaskTracker.dao.UpdateUserDAO;
import com.labbi.TaskTracker.dao.UserDAO;
import com.labbi.TaskTracker.dao.UserLoginDAO;
import com.labbi.TaskTracker.dto.UserDTO;
import com.labbi.TaskTracker.model.User;
import com.labbi.TaskTracker.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> registerNewUser(@Valid @RequestBody UserDAO userDAO){
        if(userService.findUserByEmail(userDAO.getEmail()) != null)
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email Address already used");

        userService.createNewUser(userDAO);

        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully Register user");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> loginUser(@Valid @RequestBody UserLoginDAO dao){

        User user = userService.getLoginUser(dao);

        return ResponseEntity.status(HttpStatus.CREATED).body(user != null ? "Successfully Login": "Email or password invalid");
    }

    @PutMapping("/profile-edit/{email}")
    public ResponseEntity<UserDTO> userProfileEdit(
            @Valid @RequestBody UpdateUserDAO dao,
            @PathVariable("email") @Email String email) {

        if (userService.findUserByEmail(email) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        UserDTO updatedUser = userService.userProfileEdit(dao, email);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }



}
