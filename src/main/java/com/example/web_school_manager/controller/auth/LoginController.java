package com.example.web_school_manager.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @GetMapping(value = "/")
    public ModelAndView loginWithTelegram(){
        ModelAndView modelAndView = new ModelAndView("common/base");
        return modelAndView;
    }
}
