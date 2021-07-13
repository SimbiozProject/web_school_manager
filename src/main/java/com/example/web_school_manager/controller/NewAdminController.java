package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.TgUserTable;
import com.example.web_school_manager.dao.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/admin")
public class NewAdminController {

    private final AdminService adminService;

    @Autowired
    public NewAdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/adminMenu")
    public String adminPageMenu(){
        return "adminMenu";
    }

    @RequestMapping("/schedule")
    public @ResponseBody String schedulePage(){
        return "https://calendar.google.com/calendar/embed";
    }

    @GetMapping("/userBlockList")
    public List<TgUserTable> blackListPage(){
    List<TgUserTable> blockUsers = adminService.findAllBlockUser();
//    model.addAttribute("listBlockUser", blockUsers);
    return blockUsers;
    }


    /*
@PostMapping(value = Http.FILTER)
    public String filterProductByCategory(@ModelAttribute(EntityConstant.UNIT_CATEGORY) String category, Model model) {
        List<Product> productList = productService.findAllByCategory(category);
        model.addAttribute(EntityConstant.CATEGORIES, categoryService.findAll());
        model.addAttribute(EntityConstant.PRODUCTS, productList);
        return Pages.HOME;


    @GetMapping(value = "/admin/userBlock")
    public ModelAndView blackListPage(){
        ModelAndView modelAndView = new ModelAndView("/userBlock.html");
        modelAndView.addObject("listBlockUser", adminService.findAllBlockUser());
        return modelAndView;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/registration")
    public String registerPage(Model model){
        model.addAttribute("user", new TgUserRepr());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerNewUser(@Valid @ModelAttribute("user") TgUserRepr tgUserRepr, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "registration";
        }
        if (!tgUserRepr.getPassword().equals(tgUserRepr.getRepeatPassword())) {
            bindingResult.rejectValue("password", "", "Пароли не совпадают");
            return "registration";
        }

        tgUserTableDaoWebService.create(tgUserRepr);
        return "redirect:/login";

    }
     */
}
