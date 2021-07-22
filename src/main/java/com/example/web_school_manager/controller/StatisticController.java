package com.example.web_school_manager.controller;

import com.example.web_school_manager.dao.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StatisticController {

    private final AdminService adminService;

    @Autowired
    public StatisticController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(value = "/admin/statistic")
    public ModelAndView findAllTgUsers() {
        ModelAndView modelAndView = new ModelAndView("/statistic.html");
        modelAndView.addObject("statisticList", adminService.findAllUsers());
        return modelAndView;
    }
}
