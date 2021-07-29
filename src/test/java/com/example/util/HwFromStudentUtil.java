package com.example.util;

import com.example.web_school_manager.bean.EnglishTest;
import com.example.web_school_manager.bean.HwFromStudent;
import com.example.web_school_manager.bean.TgUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class HwFromStudentUtil {

    public static ResponseEntity<HwFromStudent[]> makeMockedResponseEntityWithList() {
        return new ResponseEntity<>(makeMockedHw(), HttpStatus.OK);
    }

    public static List<HwFromStudent> makeExpHwList() {
       return List.of(
               HwFromStudent.builder()
                       .studentId(1L)
                       .hwFromStudent("123")
                       .studentName(TgUser
                               .builder()
                               .id(1L)
                               .firstName("Ann")
                               .lastName("Boo")
                               .build())
                       .build(),
               HwFromStudent.builder()
                        .studentId(2L)
                        .hwFromStudent("321")
                        .studentName(TgUser
                                .builder()
                                .id(2L)
                                .firstName("Sue")
                                .lastName("Noo")
                                .build())
                        .build());
    }


    public static HwFromStudent[] makeMockedHw() {
        HwFromStudent[] hw = {
                HwFromStudent.builder()
                        .studentId(1L)
                        .hwFromStudent("123")
                        .studentName(TgUser.builder()
                                .id(1L).firstName("Ann").lastName("Boo").build())
                        .build(),
                HwFromStudent.builder()
                        .studentId(2L)
                        .hwFromStudent("321")
                        .studentName(TgUser.builder()
                                .id(2L).firstName("Sue").lastName("Noo").build())
                        .build()};
        return hw;
    }

    public static ModelAndView getExpHwPage() {
        ModelAndView modelAndView = new ModelAndView("/test");
        modelAndView.addObject("testList", makeExpHwList());
        return modelAndView;
    }
}

