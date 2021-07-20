package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.Course;
import com.example.web_school_manager.bean.Group;
import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.bean.Roles;
import com.example.web_school_manager.dao.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(value = "admin")
    public ModelAndView adminPage(){
        ModelAndView modelAndView = new ModelAndView("/admin.html");
        return modelAndView;
    }

    @GetMapping(value = "/admin/schedule")
    public ModelAndView schedulePage(){
        ModelAndView modelAndView = new ModelAndView("/schedule.html");
        return modelAndView;
    }

    @GetMapping(value = "/admin/userBlock")
    public ModelAndView blackListPage(){
        ModelAndView modelAndView = new ModelAndView("/userBlock.html");
        modelAndView.addObject("listBlockUser", adminService.findAllBlockUser());
        return modelAndView;
    }

    @GetMapping(value = "/searchUserForBlock")
    public ModelAndView searchUserForBlock(@ModelAttribute(name = "userName") String userName){
        ModelAndView modelAndView = new ModelAndView("/listUsersForBlock.html");
        modelAndView.addObject("searchForBlockUser", adminService.searchTgUserForBlockList(userName));
        return modelAndView;
    }



    @GetMapping(value = "deleteBlockUser" + "/{id}")
    public ModelAndView deleteTgUserById(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("/deleteBlockUsers.html");
        modelAndView.addObject("blockUserDel", adminService.findBlockUserById(id));
        return modelAndView;
    }
    @PostMapping(value = "deleteBlockUser" + "/{id}")
    public ModelAndView deleteAndReturnToBlackList(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/deleteBlockUsers.html");
        adminService.deleteUserById(id);
        modelAndView.setViewName("redirect:/admin/userBlock");
        return modelAndView;
    }

    @GetMapping(value = "updateBlockUser" + "/{id}")
    public ModelAndView updateStatusBlock(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("/updateBlockStatus.html");
        modelAndView.addObject("listBlockUser", adminService.findBlockUserById(id));
        return modelAndView;
    }

    @PostMapping(value = "updateBlockUser" + "/{id}")
    public ModelAndView updateStatusBlockUser(@PathVariable(name = "id") Long id,
                                              @RequestParam(value = "blockUser") Boolean blockUser){
        ModelAndView modelAndView = new ModelAndView("/updateBlockStatus.html");
        adminService.updateBlockStatusUser(id, blockUser);
        modelAndView.setViewName("redirect:/admin/userBlock");
        return modelAndView;
    }

}
