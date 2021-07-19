package com.example.web_school_manager.dao.service;

import com.example.web_school_manager.bean.EnglishTest;
import com.example.web_school_manager.client.EnglishTestClient;
import com.example.web_school_manager.dao.repository.EnglishTestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.example.util.EnglishTestUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@SpringBootTest
class EnglishTestServiceTest {
    
    @Autowired
    EnglishTestService englishTestService;

    @MockBean
    EnglishTestRepository englishTestRepository;

    @MockBean
    EnglishTestClient englishTestClient;

    Long id = 1L;
    String question = "q";
    String first = "f";
    String second = "s";
    String third = "th";
    String fourth = "fo";
    String right = "r";

    @Test
    void findAll() {
        when(englishTestClient.findAll()).thenReturn(makeExpList());
        List<EnglishTest> actual = englishTestService.findAll();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpList());
    }

    @Test
    void addToDb() {
        EnglishTest newQuestion = makeExpEnglishTest();
        doAnswer((i) -> {
            assertEquals(makeExpEnglishTest(), i.getArgument(0));
            return null;
        }).when(englishTestRepository).save(newQuestion);
        englishTestService.addToDb(newQuestion);

    }

    @Test
    void findById() {
        when(englishTestClient.findEnglishTestById(id)).thenReturn(makeExpEnglishTest());
        EnglishTest actual = englishTestService.findById(id);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpEnglishTest());
    }

    @Test
    void deleteById() {
        doAnswer((i) -> {
            assertEquals(id, i.getArgument(0));
            return null;
        }).when(englishTestRepository).deleteById(id);
        englishTestService.deleteById(id);

    }

    @Test
    void updateDataInTest() {
        doAnswer((i) -> {
            assertEquals(id, i.getArgument(0));
            assertEquals(question, i.getArgument(1));
            assertEquals(first, i.getArgument(2));
            assertEquals(second, i.getArgument(3));
            assertEquals(third, i.getArgument(4));
            assertEquals(fourth, i.getArgument(5));
            assertEquals(right, i.getArgument(6));
            return null;
        }).when(englishTestRepository).updateDataInTest(id, question, first, second, third, fourth, right);
        englishTestService.updateDataInTest(id, question, first, second, third, fourth, right);

    }
}