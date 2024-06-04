package com.labbi.TaskTracker.controller;

import com.labbi.TaskTracker.model.dao.UpdateUserDAO;
import com.labbi.TaskTracker.model.dao.UpdateUserPasswordDAO;
import com.labbi.TaskTracker.model.dto.UserDTO;
import com.labbi.TaskTracker.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class UserController {

    private final UserService userService;


    @RequestMapping(value = "/profile-edit", method = RequestMethod.PUT)
    public ResponseEntity<UserDTO> userProfileEdit(
            @Valid @RequestBody UpdateUserDAO dao) {

        SecurityContext context = SecurityContextHolder.getContext();
        String email = context.getAuthentication().getName();
        if (userService.findUserByEmail(email) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        UserDTO updatedUser = userService.userProfileEdit(dao, email);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @RequestMapping(value = "/password-change/{email}", method = RequestMethod.PUT)
    public ResponseEntity<String> userProfileEdit(
            @Valid @RequestBody UpdateUserPasswordDAO dao,
            @PathVariable("email") @Email String email) {

        return ResponseEntity.status(HttpStatus.OK).body(userService.changePassword(dao,email));
    }



}
