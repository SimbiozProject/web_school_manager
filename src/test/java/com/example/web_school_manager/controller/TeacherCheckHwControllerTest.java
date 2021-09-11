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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@SpringBootTest
class TeacherCheckHwControllerTest {

    @Autowired
    TeacherCheckHwController teacherCheckHwController;

    @MockBean
    HwFromStudentService hwFromStudentService;

    @MockBean
    TgUser tgUser;

    @MockBean
    HwFromStudent hwFromStudent;

    private Long id;
    private String firstName;
    private String lastName;
    private int lessonNumber;

    private List<HwFromStudent> hwFromStudentList;

    @BeforeEach
    public void setup() {
        hwFromStudent = HwFromStudent.builder()
                .studentId(1L)
                .studentName(TgUser.builder().firstName("vlad").lastName("Gorgun").build())
                .lessonNumber(1)
                .hwFromStudent("dasda")
                .build();

        id = hwFromStudent.getStudentId();
        firstName = hwFromStudent.getStudentName().getFirstName();
        lastName = hwFromStudent.getStudentName().getLastName();
        lessonNumber = hwFromStudent.getLessonNumber();

        hwFromStudentList = List.of(
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

    @Test
    void checkingHwPage() {
        when(hwFromStudentService.findAll()).thenReturn(hwFromStudentList);
        ModelAndView actual = teacherCheckHwController.checkingHwPage();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedViewFromCheckingHwPage());
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
        ModelAndView modelAndView = new ModelAndView("/deleteHwFromStudent");
        modelAndView.addObject("hw", hwFromStudentService.findById(id));
        return modelAndView;
    }

    @Test
    void deleteHw() {
        doAnswer((i) -> {
            assertEquals(id, i.getArgument(0));
            return null;
        }).when(hwFromStudentService).deleteById(id);
        ModelAndView actual = teacherCheckHwController.deleteHw(id);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedViewFromDeleteHw(id));
    }

    private ModelAndView getExpectedViewFromDeleteHw(Long id) {
        ModelAndView modelAndView = new ModelAndView("/deleteHwFromStudent");
        hwFromStudentService.deleteById(id);
        modelAndView.setViewName("redirect:/teacherCheckHw");
        return modelAndView;
    }

    @Test
    void searchFirstname() {
        when(hwFromStudentService.findByFirstName(firstName)).thenReturn(hwFromStudentList);
        ModelAndView actual = teacherCheckHwController.searchFirstname(firstName);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedViewFromSearchFirstName(firstName));
    }

    private ModelAndView getExpectedViewFromSearchFirstName(String name) {
        ModelAndView modelAndView = new ModelAndView("/teacherCheckHw");
        modelAndView.addObject("hwFromStudentList", hwFromStudentService.findByFirstName(name));
        return modelAndView;
    }

    @Test
    void searchLastName() {
        when(hwFromStudentService.findByLastName(lastName)).thenReturn(hwFromStudentList);
        ModelAndView actual = teacherCheckHwController.searchLastName(lastName);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedViewForSearchLastName(lastName));
    }

    private ModelAndView getExpectedViewForSearchLastName(String name) {
        ModelAndView modelAndView = new ModelAndView("/teacherCheckHw");
        modelAndView.addObject("hwFromStudentList", hwFromStudentService.findByLastName(name));
        return modelAndView;
    }

    @Test
    void searchLesson() {
        when(hwFromStudentService.findByLesson(lessonNumber)).thenReturn(hwFromStudentList);
        ModelAndView actual = teacherCheckHwController.searchLesson(lessonNumber);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedViewForSearchLesson(lessonNumber));
    }

    private ModelAndView getExpectedViewForSearchLesson(Integer lessonNumber) {
        ModelAndView modelAndView = new ModelAndView("/teacherCheckHw");
        modelAndView.addObject("hwFromStudentList", hwFromStudentService.findByLesson(lessonNumber));
        return modelAndView;
    }
}