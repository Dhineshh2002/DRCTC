package org.DRTCT.controller;

import org.DRTCT.entity.User;
import org.DRTCT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping (value = "/user")
public class HomeController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ModelAndView homePage(@RequestParam(value = "username", required = true) String username, 
                                 @RequestParam(value = "password", required = true) String password) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUser(username);
        
        if (user != null && user.getPassword().equals(password)) {
            modelAndView.addObject("user", user); 
            modelAndView.setViewName("home"); 
        } else {
            modelAndView.addObject("error", "Invalid username or password!");
            modelAndView.setViewName("userlogin"); 
        }
        
        return modelAndView;
    }

    @GetMapping (value = "/login")
    private ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userlogin");
        return modelAndView;
    }

    @GetMapping (value = "/signup")
    private ModelAndView signup(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersignup");
        return modelAndView;
    }

}
