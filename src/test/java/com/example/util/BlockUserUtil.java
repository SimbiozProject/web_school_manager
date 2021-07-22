package com.example.util;

import com.example.web_school_manager.bean.TgUser;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

public class BlockUserUtil {


    public static List<TgUser> makeExpectedBlockUsers(){
        return List.of(
                TgUser.builder().id(1L).userName("olga").blockUser(true).build(),
                TgUser.builder().id(2L).userName("emily").blockUser(true).build()
        );
    }

    public static Optional<TgUser> makeExpectedSearchUserForBlock(){
        return Optional.of(TgUser.builder().id(1L).userName("olga").blockUser(true).build());
    }

    public static TgUser makeExpectedSearchUserByName(){
        return  TgUser.builder().id(1L).userName("olga").blockUser(true).build();
    }

    public static TgUser makeExpectedUpdateStatusBlockUser(){
        return TgUser.builder().id(1L).userName("olga").blockUser(true).build();
    }

    public static ModelAndView getExpectedViewBlackListPage() {
        var modelAndView = new ModelAndView("/userBlock");
        modelAndView.addObject("listBlockUser", makeExpectedBlockUsers());
        return modelAndView;
    }

    public static ModelAndView getExpectedViewSearchUserForBlock(){
        ModelAndView modelAndView = new ModelAndView("/searchUserForBlock");
        modelAndView.addObject("searchForBlockUser", makeExpectedSearchUserForBlock());
        return modelAndView;
    }

    public static ModelAndView getExpectedViewFindTgUserById(){
        ModelAndView modelAndView = new ModelAndView("/deleteBlockUsers");
        modelAndView.addObject("blockUserDel", makeExpectedSearchUserForBlock());
        return modelAndView;
    }

    public static ModelAndView getExpectedViewDeleteAndReturn(Long id){
        ModelAndView modelAndView = new ModelAndView("/deleteBlockUsers");
        modelAndView.setViewName("redirect:/admin/userBlock");
        return modelAndView;
    }

    public static ModelAndView getExpectedViewUpdateStatusBlockUser(Long id, Boolean blockUser){
        ModelAndView modelAndView = new ModelAndView("/updateBlockStatus.html");
        makeExpectedUpdateStatusBlockUser();
        modelAndView.setViewName("redirect:/admin/userBlock");
        return modelAndView;
    }
}
