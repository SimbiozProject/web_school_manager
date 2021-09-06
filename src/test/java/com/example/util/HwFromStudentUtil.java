package com.example.util;

import com.example.web_school_manager.bean.HwFromStudent;
import com.example.web_school_manager.bean.TgUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class HwFromStudentUtil {

    public static ResponseEntity<HwFromStudent[]> makeMockedResponseEntityWithList() {
        return new ResponseEntity<>(makeMockedHws(), HttpStatus.OK);
    }

    public static ResponseEntity<HwFromStudent> makeMockedResponseEntityWithHw() {
        return new ResponseEntity<HwFromStudent>(makeExpHw(), HttpStatus.OK);
    }

    public static TgUser firstStudent = TgUser
            .builder()
            .id(1L)
            .firstName("Ann")
            .lastName("Boo")
            .build();

    public static TgUser secondStudent = TgUser
            .builder()
            .id(2L)
            .firstName("Sue")
            .lastName("Noo")
            .build();

    public static List<HwFromStudent> makeExpHwList() {
        return List.of(
                HwFromStudent.builder()
                        .studentId(1L)
                        .hwFromStudent("123")
                        .studentName(firstStudent)
                        .lessonNumber(1)
                        .build(),
                HwFromStudent.builder()
                        .studentId(2L)
                        .hwFromStudent("321")
                        .studentName(secondStudent)
                        .lessonNumber(1)
                        .build());
    }

    public static HwFromStudent makeExpHw() {
        return HwFromStudent.builder()
                .studentId(1L)
                .hwFromStudent("123")
                .studentName(firstStudent)
                .lessonNumber(1).build();
    }


    public static HwFromStudent[] makeMockedHws() {
        HwFromStudent[] hw = {
                HwFromStudent.builder()
                        .studentId(1L)
                        .hwFromStudent("123")
                        .studentName(firstStudent)
                        .lessonNumber(1)
                        .build(),
                HwFromStudent.builder()
                        .studentId(2L)
                        .hwFromStudent("321")
                        .studentName(secondStudent)
                        .lessonNumber(1)
                        .build()};
        return hw;
    }

    public static ModelAndView getExpHwPage() {
        ModelAndView modelAndView = new ModelAndView("/test");
        modelAndView.addObject("testList", makeExpHwList());
        return modelAndView;
    }
}

