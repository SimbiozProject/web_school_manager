package com.example.web_school_manager.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.web_school_manager.bean.TgUserTable;
import com.example.web_school_manager.dao.service.AdminService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.servlet.ModelAndView;

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

    private List<TgUserTable> makeExpectedUsers() {
        return List.of(
                TgUserTable.builder().id(1L).userName("max").build(),
                TgUserTable.builder().id(2L).userName("bax").build());
    }
}
