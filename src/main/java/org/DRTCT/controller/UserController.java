package org.DRTCT.controller;

import org.DRTCT.entity.User;
import org.DRTCT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = "/add")
    public ModelAndView addUser(@RequestBody User user) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.addUser(user);
            modelAndView.setViewName("userlogin");
            return modelAndView;
        } catch (Exception e) {
            modelAndView.addObject("error", e.getMessage());
            modelAndView.setViewName("usersignup");
            return modelAndView;
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
            // User exists, return the user object as JSON
            return ResponseEntity.ok(foundUser);
        } else {
            // User does not exist, return a 401 Unauthorized response
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
