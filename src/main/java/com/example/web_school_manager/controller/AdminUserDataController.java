package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.Course;
import com.example.web_school_manager.bean.Group;
import com.example.web_school_manager.bean.Roles;
import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.dao.service.AdminService;
import com.example.web_school_manager.dao.service.EnglishTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class AdminUserDataController {

   @Autowired
   AdminService adminService;

    @GetMapping(value = "deleteUser" + "/{id}")
    public ModelAndView deleteUserById(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("/deleteUser.html");
        modelAndView.addObject("listUser", adminService.findBlockUserById(id));
        return modelAndView;
    }
    @PostMapping(value = "deleteUser" + "/{id}")
    public ModelAndView deleteAndReturnToUserList(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/deleteUser.html");
        adminService.deleteUserById(id);
        modelAndView.setViewName("redirect:/admin/statistic");
        return modelAndView;
    }
    @GetMapping(value = "updateUser" + "/{id}")
    public ModelAndView updateDataUser(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("/updateUserInfo.html");
        modelAndView.addObject("listUserForUpdate", adminService.findBlockUserById(id));
        return modelAndView;
    }

    @PostMapping(value = "updateUser" + "/{id}")
    public ModelAndView updateAllDataOfUsers(@PathVariable(name = "id") Long id,
                                             @RequestParam(value = "userName") String userName,
                                             @RequestParam(value = "firstName") String firstName,
                                             @RequestParam(value = "lastName") String lastName,
                                             @RequestParam(value = "email") String email,
                                             @RequestParam(value = "dateOfBirthday") Date dateOfBirthday,
                                             @RequestParam(value = "active") Boolean active,
                                             @RequestParam(value = "blockUser") Boolean blockUser,
                                             @RequestParam(value = "payment") Boolean payment,
                                             @RequestParam(value = "roles") Roles roles,
                                             @RequestParam(value = "courseUser") Course courseUser,
                                             @RequestParam(value = "groupUser") Group groupUser){
        ModelAndView modelAndView = new ModelAndView("/updateUserInfo.html");
        adminService.updateDataOfUser(id, userName, firstName, lastName, email, dateOfBirthday,
                active, blockUser, payment, roles, courseUser, groupUser);
        modelAndView.setViewName("redirect:/admin/statistic");
        return modelAndView;
    }

    @GetMapping(value = "/admin/addUser")
    public ModelAndView addUserToTable(){
        ModelAndView modelAndView = new ModelAndView("/addUser.html");
        return modelAndView;
    }

    @PostMapping(value = "/admin/addUser")
    public ModelAndView addTgUserToTable(//@RequestParam(name = "id") Long id,
                                         @RequestParam(value = "userName") String userName,
                                         @RequestParam(value = "firstName") String firstName,
                                         @RequestParam(value = "lastName") String lastName,
                                         @RequestParam(value = "email") String email,
                                         @RequestParam(value = "dateOfBirthday") Date dateOfBirthday,
                                         @RequestParam(value = "active") Boolean active,
                                         @RequestParam(value = "blockUser") Boolean blockUser,
                                         @RequestParam(value = "payment") Boolean payment,
                                         @RequestParam(value = "roles") Roles roles,
                                         @RequestParam(value = "courseUser") Course courseUser,
                                         @RequestParam(value = "groupUser") Group groupUser){
        ModelAndView modelAndView = new ModelAndView("/addUser.html");
        TgUser newTgUser = TgUser.builder()
                .userName(userName)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .dateOfBirthday(dateOfBirthday)
                .active(active)
                .blockUser(blockUser)
                .payment(payment)
                .roles(roles)
                .courseUser(courseUser)
                .groupUser(groupUser)
                .build();
        adminService.addUserToDB(newTgUser);
        modelAndView.setViewName("redirect:/admin/statistic");
        return modelAndView;
    }
}
