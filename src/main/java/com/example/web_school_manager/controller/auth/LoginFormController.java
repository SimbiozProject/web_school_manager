package com.example.web_school_manager.controller.auth;

import com.example.web_school_manager.controller.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginFormController {

    @Autowired
    TelegramUserService telegramUserService;
    @GetMapping(value = "/tglogin")
    public ModelAndView loginWithTelegram() {
        ModelAndView modelAndView = new ModelAndView("/login_form");
        return modelAndView;
    }

    @PostMapping(value = "/tglogin")
    public String loginWithTelegram(
            @RequestParam String username) {
        telegramUserService.processUserName(username);
        ModelAndView modelAndView = new ModelAndView("/code_form");
        return "redirect:/tgconfirm";
    }

    @GetMapping(value = "/tgconfirm")
    public ModelAndView confirmWithCode() {
        ModelAndView modelAndView = new ModelAndView("/code_form");
        return modelAndView;
    }

    @PostMapping(value = "/tgconfirm")
    public String confirmWithCode(
            @RequestParam short code) {
        try {
            telegramUserService.validateUserCode(code);
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/tglogin";
        }
    }
}
