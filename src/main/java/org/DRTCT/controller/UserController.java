package org.DRTCT.controller;

import org.DRTCT.entity.User;
import org.DRTCT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping (value = "/signup")
    private String openSignUpPage(){
        //return "http://localhost:63342/DRTCT/templates/usersignup.html";
        return "usersignup";
    }

    @RequestMapping (value = "/login")
    private String openLoginPage(){
        return "userlogin";
    }

    @RequestMapping (value = "/user", method = RequestMethod.POST)
    private int addUser(@RequestBody User user) {

        String name = user.getName();

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
