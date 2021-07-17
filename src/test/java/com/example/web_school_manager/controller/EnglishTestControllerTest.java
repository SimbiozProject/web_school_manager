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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
        when(englishTestService.findAll()).thenReturn(makeExpectedList());
        ModelAndView actualResult = englishTestController.testPage();
        assertThat(actualResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedResultWithList(viewName, attributeName));
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
        doAnswer((i) -> {
            assertEquals(makeExpectedEnglishTest(), i.getArgument(0));
            return null;
        }).when(englishTestService).addToDb(makeExpectedEnglishTest());
        ModelAndView actualResult = englishTestController.addTest("q", "f", "s", "th", "fo", "r");
        assertThat(actualResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedResultAddTest());

    }


    @Test
    void updateTestPage() {
        Long id = 1L;
        when(englishTestService.findById(id)).thenReturn(makeExpectedEnglishTest());
        ModelAndView actualResult = englishTestController.updateTestPage(id);
        assertThat(actualResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedResultUpdateTestPage(id));
    }


    @Test
    void updateTest() {
        doAnswer((i) -> {
            assertEquals(1L, (Long) i.getArgument(0));
            assertEquals("q", i.getArgument(1));
            assertEquals("f", i.getArgument(2));
            assertEquals("s", i.getArgument(3));
            assertEquals("th", i.getArgument(4));
            assertEquals("fo", i.getArgument(5));
            assertEquals("r", i.getArgument(6));
            return null;
        }).when(englishTestService).updateDataInTest(1L, "q", "f", "s", "th", "fo", "r");
        //doNothing().when(englishTestService).updateDataInTest(1L, "q", "f", "s", "th", "fo", "r");
        //todo what is better: doAnswer or doNothing?
        ModelAndView actualResult = englishTestController.updateTest(1L, "q", "f", "s", "th", "fo", "r");
        assertThat(actualResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedResultUpdateTest());
    }



    @Test
    void deleteTestPage() {
    }

    @Test
    void deleteTest() {
    }

    private List<EnglishTest> makeExpectedList() {
        return List.of(
                EnglishTest.builder()
                        .id(1L).question("q").firstAnswer("f").secondAnswer("s").thirdAnswer("th").fourthAnswer("fo").rightAnswer("r")
                        .build(),
                EnglishTest.builder()
                        .id(2L).question("q2").firstAnswer("f2").secondAnswer("s2").thirdAnswer("th2").fourthAnswer("fo2").rightAnswer("r2")
                        .build());
    }

    private ModelAndView getExpectedResultWithList(String viewName, String attributeName) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject(attributeName, makeExpectedList());
        return modelAndView;
    }

    private ModelAndView getExpectedResultWithoutService(String viewName) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        return modelAndView;
    }

    private ModelAndView getExpectedResultAddTest() {
        ModelAndView modelAndView = new ModelAndView("/addTest");
        modelAndView.setViewName("redirect:/test");
        return modelAndView;
    }


    private EnglishTest makeExpectedEnglishTest() {
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

    private ModelAndView getExpectedResultUpdateTestPage(Long id) {
        ModelAndView modelAndView = new ModelAndView("/updateTest");
        modelAndView.addObject("testList", makeExpectedEnglishTest());
        return modelAndView;
    }

    private ModelAndView getExpectedResultUpdateTest() {
        ModelAndView modelAndView = new ModelAndView("/updateTest");
        modelAndView.setViewName("redirect:/test");
        return modelAndView;
    }
}