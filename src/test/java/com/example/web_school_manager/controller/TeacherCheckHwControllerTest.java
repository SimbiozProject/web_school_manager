package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.HwFromStudent;
import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.dao.service.HwFromStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class TeacherCheckHwControllerTest {

    @Autowired
    TeacherCheckHwController teacherCheckHwController;

    @MockBean
    HwFromStudentService hwFromStudentService;

    @MockBean
    TgUser tgUser;

    @Test
    void checkingHwPage() {
        when(hwFromStudentService.findAll()).thenReturn(makeExpectedHwFromStudent());
        ModelAndView actual = teacherCheckHwController.checkingHwPage();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedView());
    }

    private List<HwFromStudent> makeExpectedHwFromStudent() {
        return List.of(
                HwFromStudent.builder()
                        .studentId(1L)
                        .studentName(TgUser.builder().firstName("voava").build())
                        .lessonNumber(1)
                        .hwFromStudent("nikolaevich")
                        .build()
        );
    }

    private ModelAndView getExpectedView() {
        ModelAndView modelAndView = new ModelAndView("/teacherCheckHw");
        modelAndView.addObject("hwFromStudentList", hwFromStudentService.findAll());
        return modelAndView;
    }
}