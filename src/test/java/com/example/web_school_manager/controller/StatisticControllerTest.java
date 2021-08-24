package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.dao.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class StatisticControllerTest {

    @Autowired
    StatisticController statisticController;
    @MockBean
    AdminService adminService;

    @Test
    void findAllTgUsers() {
        when(adminService.findAllUsers()).thenReturn(makeExpectedUsers());
        ModelAndView viewResult = statisticController.findAllTgUsers();
        assertThat(viewResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedView());
    }

    private ModelAndView getExpectedView() {
        var modelAndView = new ModelAndView("/statistic.html");
        modelAndView.addObject("statisticList", makeExpectedUsers());
        return modelAndView;
    }

    private List<TgUser> makeExpectedUsers() {
        return List.of(
                TgUser.builder().id(1L).userName("max").build(),
                TgUser.builder().id(2L).userName("bax").build());
    }
}
