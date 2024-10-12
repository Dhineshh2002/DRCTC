package org.DRTCT.controller;

import org.DRTCT.entity.User;
import org.DRTCT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping (value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping (value = "/signup")
    private ModelAndView signup(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersignup");
        return modelAndView;
    }

    @RequestMapping (value = "/login")
    private ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userlogin");
        return modelAndView;
    }

    @RequestMapping("/home")
    public ModelAndView homePage(@RequestParam(value = "username", required = true) String username) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUser(username);
        if (user != null) {
            modelAndView.addObject("user", user);
        } else {
            modelAndView.addObject("error", "User not found");
        }
        modelAndView.setViewName("home"); // Set the view for the home page
        return modelAndView;
    }

    @PostMapping(value = "/add")
    private int addUser(@RequestBody User user) {
        return userService.addUser(user);
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


//
//    @RequestMapping (value = "/update/user")
//    private String updateUser(User user){
//
//    }
//
//    @RequestMapping (value = "/get/user")
//    private User getUser(User user){
//
//    }
}
