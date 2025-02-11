package org.DRTCT.controller;

import org.DRTCT.entity.User;
import org.DRTCT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
@RequestMapping (value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (DuplicateKeyException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }


    @GetMapping(value = "/get")
    public ArrayList<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(value = "/check")
    public ResponseEntity<User> checkUserExist(@RequestBody User user) {
        User foundUser = userService.checkUserExist(user);
        if (foundUser != null) {
            return ResponseEntity.ok(foundUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        try {
            if(user.getUsername() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username is required");
            }
            userService.updateUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User updated successfully");
        } catch (NoSuchFieldException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
