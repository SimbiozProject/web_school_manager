package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.dao.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlockUserController {

    private final AdminService adminService;

    @Autowired
    public BlockUserController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(value = "/admin/userBlock")
    public ModelAndView blackListPage(){
        ModelAndView modelAndView = new ModelAndView("/userBlock");
        modelAndView.addObject("listBlockUser", adminService.findAllBlockUser());
        return modelAndView;
    }

    @GetMapping(value = "/searchUserForBlock")
    public ModelAndView searchUserForBlock(@ModelAttribute(name = "userName") String userName) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/listUsersForBlock");
        modelAndView.addObject("searchForBlockUser", adminService.searchTgUserForBlockList(userName));
        return modelAndView;
    }

    @GetMapping(value = "deleteBlockUsers" + "/{id}")
    public ModelAndView deleteTgUserById(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("/deleteBlockUsers");
        modelAndView.addObject("blockUserDel", adminService.findBlockUserById(id));
        return modelAndView;
    }


    @PostMapping(value = "deleteBlockUsers" + "/{id}")
    public ModelAndView deleteAndReturnToBlackList(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/deleteBlockUsers");
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
