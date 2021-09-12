package com.example.web_school_manager.controller;

import com.example.web_school_manager.dao.service.UserAnswerService;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserAnswerController {

    @Autowired
    private UserAnswerService userAnswerService;

    @GetMapping(value = "/allUsersTest")
    public ModelAndView getAllUserTest() {
        ModelAndView modelAndView = new ModelAndView("/allUsersTest");
        modelAndView.addObject("listUserAnswerTable", userAnswerService.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/searchByUserName")
    public ModelAndView searchByUserName(@ModelAttribute(name = "userName") String userName) {
        ModelAndView modelAndView = new ModelAndView("/allUsersTest");
        modelAndView.addObject("listUserAnswerTable", userAnswerService.findByUserName(userName));
        return modelAndView;
    }

    @GetMapping(value = "/searchById")
    public ModelAndView searchById(@ModelAttribute(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/allUsersTest");
        modelAndView.addObject("listUserAnswerTable", userAnswerService.findById(id));
        return modelAndView;
    }

    @GetMapping(value = "allUsersTest/userTest/{id}")
    public ModelAndView getUserAnswerById(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/userTest");
        modelAndView.addObject("userAnswer", userAnswerService.findById(id));
        return modelAndView;

    }
}
