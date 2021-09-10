package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.HwFromStudent;
import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.dao.service.HwFromStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class TeacherCheckHwControllerTest {

    @Autowired
    TeacherCheckHwController teacherCheckHwController;

    @MockBean
    HwFromStudentService hwFromStudentService;

    @MockBean
    TgUser tgUser;

    private Long id;
    private HwFromStudent hwFromStudent;

    @BeforeEach
    public void setup() {
        hwFromStudent = HwFromStudent.builder()
                .studentId(1L)
                .studentName(TgUser.builder().userName("vlad").build())
                .lessonNumber(1)
                .hwFromStudent("dasda")
                .build();
        id = hwFromStudent.getStudentId();
    }

    @Test
    void checkingHwPage() {
        when(hwFromStudentService.findAll()).thenReturn(makeExpectedHwFromStudentFromCheckingHwPage());
        ModelAndView actual = teacherCheckHwController.checkingHwPage();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedViewFromCheckingHwPage());
    }

    private List<HwFromStudent> makeExpectedHwFromStudentFromCheckingHwPage() {
        return List.of(
                HwFromStudent.builder()
                        .studentId(1L)
                        .studentName(TgUser.builder().firstName("vova").build())
                        .lessonNumber(1)
                        .hwFromStudent("nikolaevich")
                        .build(),
                HwFromStudent.builder()
                        .studentId(2L)
                        .studentName(TgUser.builder().firstName("vasia").build())
                        .lessonNumber(2)
                        .hwFromStudent("orepri")
                        .build()
        );
    }

    private ModelAndView getExpectedViewFromCheckingHwPage() {
        ModelAndView modelAndView = new ModelAndView("/teacherCheckHw");
        modelAndView.addObject("hwFromStudentList", hwFromStudentService.findAll());
        return modelAndView;
    }

    @Test
    void deleteHwFrom() {
        when(hwFromStudentService.findById(id)).thenReturn(hwFromStudent);
        ModelAndView actual = teacherCheckHwController.deleteHwFrom(id);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedViewFromDeleteHwFrom(id));
    }

    private ModelAndView getExpectedViewFromDeleteHwFrom(Long id) {
        ModelAndView modelAndView = new ModelAndView("deleteHwFromStudent");
        modelAndView.addObject("hw", hwFromStudentService.findById(id));
        return modelAndView;
    }

//    private HwFromStudent exampleFromStudent() {
//        return HwFromStudent.builder()
//                .studentId(1L)
//                .studentName(TgUser.builder().userName("vlad").build())
//                .lessonNumber(1)
//                .hwFromStudent("dasda")
//                .build();
//    }
}