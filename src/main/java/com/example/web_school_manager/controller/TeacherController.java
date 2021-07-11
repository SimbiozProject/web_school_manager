package com.example.web_school_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "/")
public class TeacherController {

    @GetMapping(value = "teacher")
    public ModelAndView teacherPage(){
        ModelAndView modelAndView = new ModelAndView("/teacher");
        return modelAndView;
    }
}
