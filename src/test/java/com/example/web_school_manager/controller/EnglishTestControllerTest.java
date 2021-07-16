package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.EnglishTest;
import com.example.web_school_manager.dao.service.EnglishTestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class EnglishTestControllerTest {

    @Autowired
    EnglishTestController englishTestController;

    @MockBean
    EnglishTestService englishTestService;


    @Test
    void testPage() {
        String viewName = "/test";
        String attributeName = "testList";
        when(englishTestService.findAll()).thenReturn(makeFindAll());
        ModelAndView actualResult = englishTestController.testPage();
        assertThat(actualResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedFindAll(viewName, attributeName));
    }


    @Test
    void addTestPage() {
        String viewName = "/addTest";
        ModelAndView actualResult = englishTestController.addTestPage();
        assertThat(actualResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedResultWithoutService(viewName));
    }

    @Test
    void addTest() {
        EnglishTest newQuestion = makeEnglishTest();
        when(englishTestService.addToDb(newQuestion)).getMock();
        ModelAndView actualResult = englishTestController.addTest("q", "f", "s", "th", "fo", "r");
    }

    private EnglishTest makeEnglishTest() {
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


    @Test
    void updateTestPage() {

    }

    @Test
    void updateTest() {
    }

    @Test
    void deleteTestPage() {
    }

    @Test
    void deleteTest() {
    }

    private List<EnglishTest> makeFindAll() {
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

    private ModelAndView getExpectedFindAll(String viewName, String attributeName) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject(attributeName, makeFindAll());
        return modelAndView;
    }

    private ModelAndView getExpectedResultWithoutService(String viewName) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        return modelAndView;
    }
}