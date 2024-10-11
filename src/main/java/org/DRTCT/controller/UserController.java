package org.DRTCT.controller;

import org.DRTCT.entity.User;
import org.DRTCT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping (value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping (value = "/signup")
    private ModelAndView openSignUpPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersignup");
        return modelAndView;
    }

    @RequestMapping (value = "/login")
    private ModelAndView openLoginPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userlogin");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    private int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
//
//    @RequestMapping (value = "/check/user")
//    private String checkUserExist(User user){
//
//    }
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
