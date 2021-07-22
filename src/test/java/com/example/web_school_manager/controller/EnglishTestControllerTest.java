package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.EnglishTest;
import com.example.web_school_manager.dao.service.EnglishTestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import static com.example.util.EnglishTestUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

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
        //todo refactor with verify
       /* EnglishTest actualTest = EnglishTest.builder()
                .id(id)
                .question(question)
                .firstAnswer(first)
                .secondAnswer(second)
                .thirdAnswer(third)
                .fourthAnswer(fourth)
                .rightAnswer(right)
                .build();
        verify(englishTestService, times(1)).addToDb(actualTest);*/
        EnglishTest actualTest = EnglishTest.builder()
                .id(id)
                .question(question)
                .firstAnswer(first)
                .secondAnswer(second)
                .thirdAnswer(third)
                .fourthAnswer(fourth)
                .rightAnswer(right)
                .build();
        assertEquals(makeExpEnglishTest(), actualTest);
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
        ModelAndView actualResult = englishTestController.updateTest(id, question, first, second, third, fourth, right);
        verify(englishTestService, times(1)).updateDataInTest(makeExpEnglishTest());
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