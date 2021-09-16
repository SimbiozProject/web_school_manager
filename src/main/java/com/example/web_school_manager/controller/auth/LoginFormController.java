package com.example.web_school_manager.controller.auth;

import com.example.web_school_manager.controller.service.TelegramUserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
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
        ModelAndView modelAndView = new ModelAndView("/login/signin");
        modelAndView.addObject("title", "Sing in with telegram");
        return modelAndView;
    }

    @PostMapping(value = "/tglogin")
    public String loginWithTelegram(@RequestParam String username, HttpSession session) {
        session.setAttribute("username", username);
        return "redirect:/"+telegramUserService.processUserName(username);
    }

    @GetMapping(value = "/tgconfirm")
    public ModelAndView confirmWithCode() {
        ModelAndView modelAndView = new ModelAndView("login/code_form");
        return modelAndView;
    }

    @PostMapping(value = "/tgconfirm")
    public String confirmWithCode(@RequestParam String code, HttpSession session) {
        try {
            telegramUserService.validateUserCode(code, session.getAttribute("username").toString());
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/500";
        }
    }
}
