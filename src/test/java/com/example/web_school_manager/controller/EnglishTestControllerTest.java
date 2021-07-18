package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.EnglishTest;
import com.example.web_school_manager.dao.service.EnglishTestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.servlet.ModelAndView;

import static com.example.util.EnglishTestUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@SpringBootTest
class EnglishTestControllerTest {

    @Autowired
    EnglishTestController englishTestController;

    @MockBean
    EnglishTestService englishTestService;

    Long id = 1L;
    String question = "q";
    String first = "f";
    String second = "s";
    String third = "th";
    String fourth = "fo";
    String right = "r";


    @Test
    void testPage() {
        when(englishTestService.findAll()).thenReturn(makeExpList());
        ModelAndView actualResult = englishTestController.testPage();
        assertThat(actualResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpTestPage());
    }


    @Test
    void addTestPage() {
        ModelAndView actualResult = englishTestController.addTestPage();
        assertThat(actualResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpAddTestPage());
    }

    @Test
    void addTest() {
        doAnswer((i) -> {
            assertEquals(makeExpEnglishTest(), i.getArgument(0));
            return null;
        }).when(englishTestService).addToDb(makeExpEnglishTest());
        ModelAndView actualResult = englishTestController.addTest(question, first, second, third, fourth, right);
        EnglishTest actuslTest = EnglishTest.builder()
                .id(id)
                .question(question)
                .firstAnswer(first)
                .secondAnswer(second)
                .thirdAnswer(third)
                .fourthAnswer(fourth)
                .rightAnswer(right)
                .build();
        assertEquals(makeExpEnglishTest(), actuslTest);
        assertThat(actualResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpAddTest());

    }


    @Test
    void updateTestPage() {
        when(englishTestService.findById(id)).thenReturn(makeExpEnglishTest());
        ModelAndView actualResult = englishTestController.updateTestPage(id);
        assertThat(actualResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpUpdateTestPage(id));
    }


    @Test
    void updateTest() {
        doAnswer((i) -> {
            assertEquals(id, i.getArgument(0));
            assertEquals(question, i.getArgument(1));
            assertEquals(first, i.getArgument(2));
            assertEquals(second, i.getArgument(3));
            assertEquals(third, i.getArgument(4));
            assertEquals(fourth, i.getArgument(5));
            assertEquals(right, i.getArgument(6));
            return null;
        }).when(englishTestService).updateDataInTest(id, question, first, second, third, fourth, right);
        //doNothing().when(englishTestService).updateDataInTest(id, question, first, second, third, fourth, right);
        //todo what is better: doAnswer or doNothing?
        ModelAndView actualResult = englishTestController.updateTest(id, question, first, second, third, fourth, right);
        assertThat(actualResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpUpdateTest());
    }


    @Test
    void deleteTestPage() {
        when(englishTestService.findById(id)).thenReturn(makeExpEnglishTest());
        ModelAndView actualResult = englishTestController.deleteTestPage(id);
        assertThat(actualResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpDeleteTestPage(id));
    }


    @Test
    void deleteTest() {
        doAnswer((i) -> {
            assertEquals(id, i.getArgument(0));
            return null;
        }).when(englishTestService).deleteById(id);
        ModelAndView actualResult = englishTestController.deleteTest(id);
        assertThat(actualResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpDeleteTest(id));

    }

}