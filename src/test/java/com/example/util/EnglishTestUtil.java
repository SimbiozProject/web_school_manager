package com.example.util;

import com.example.web_school_manager.bean.EnglishTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class EnglishTestUtil {

    public static EnglishTest makeExpEnglishTest() {
        return EnglishTest.builder()
                .id(1L)
                .question("q")
                .firstAnswer("f")
                .secondAnswer("s")
                .thirdAnswer("th")
                .fourthAnswer("fo")
                .rightAnswer("r")
                .build();
    }

    public static List<EnglishTest> makeExpList() {
        return List.of(
                EnglishTest.builder()
                        .id(1L)
                        .question("q")
                        .firstAnswer("f")
                        .secondAnswer("s")
                        .thirdAnswer("th")
                        .fourthAnswer("fo")
                        .rightAnswer("r")
                        .build(),
                EnglishTest.builder()
                        .id(2L)
                        .question("q2")
                        .firstAnswer("f2")
                        .secondAnswer("s2")
                        .thirdAnswer("th2")
                        .fourthAnswer("fo2")
                        .rightAnswer("r2")
                        .build());
    }

    public static ModelAndView getExpTestPage() {
        ModelAndView modelAndView = new ModelAndView("/test");
        modelAndView.addObject("testList", makeExpList());
        return modelAndView;
    }

    public static ModelAndView getExpAddTestPage() {
        ModelAndView modelAndView = new ModelAndView("/addTest");
        return modelAndView;
    }

    public static ModelAndView getExpAddTest() {
        ModelAndView modelAndView = new ModelAndView("/addTest");
        modelAndView.setViewName("redirect:/test");
        return modelAndView;
    }

    public static ModelAndView getExpUpdateTestPage(Long id) {
        ModelAndView modelAndView = new ModelAndView("/updateTest");
        modelAndView.addObject("testList", makeExpEnglishTest());
        return modelAndView;
    }

    public static ModelAndView getExpUpdateTest() {
        ModelAndView modelAndView = new ModelAndView("/updateTest");
        modelAndView.setViewName("redirect:/test");
        return modelAndView;
    }

    public static ModelAndView getExpDeleteTestPage(Long id) {
        ModelAndView modelAndView = new ModelAndView("/deleteTest");
        modelAndView.addObject("test", makeExpEnglishTest());
        return modelAndView;
    }

    public static ModelAndView getExpDeleteTest(Long id) {
        ModelAndView modelAndView = new ModelAndView("/deleteTest");
        modelAndView.setViewName("redirect:/test");
        return modelAndView;
    }

    public static ResponseEntity<EnglishTest[]> makeMockedResponseEntity() {
        return new ResponseEntity<EnglishTest[]>(makeMockedTests(), HttpStatus.OK);
    }

    public static EnglishTest[] makeMockedTests() {
        EnglishTest[] tests = {
                EnglishTest.builder()
                        .id(1L)
                        .question("q")
                        .firstAnswer("f")
                        .secondAnswer("s")
                        .thirdAnswer("th")
                        .fourthAnswer("fo")
                        .rightAnswer("r")
                        .build(),
                EnglishTest.builder()
                        .id(2L)
                        .question("q2")
                        .firstAnswer("f2")
                        .secondAnswer("s2")
                        .thirdAnswer("th2")
                        .fourthAnswer("fo2")
                        .rightAnswer("r2")
                        .build()};
        return tests;
    }
}
