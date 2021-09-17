package com.example.web_school_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

  @GetMapping(value = "/500")
  public ModelAndView loginWithTelegram() {
    ModelAndView modelAndView = new ModelAndView("500");
    modelAndView.addObject("title", "Error");
    return modelAndView;
  }

}
