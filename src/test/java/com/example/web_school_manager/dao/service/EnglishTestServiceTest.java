package com.example.web_school_manager.dao.service;

import com.example.web_school_manager.bean.EnglishTest;
import com.example.web_school_manager.client.EnglishTestClient;
import com.example.web_school_manager.dao.repository.EnglishTestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static com.example.util.EnglishTestUtil.makeExpEnglishTest;
import static com.example.util.EnglishTestUtil.makeExpList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, properties = {"spring.cloud.config.enabled=false"})
class EnglishTestServiceTest {

    @Autowired
    EnglishTestService englishTestService;

    @MockBean
    EnglishTestRepository englishTestRepository;

    @MockBean
    EnglishTestClient englishTestClient;



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
        englishTestService.addToDb(newQuestion);
        verify(englishTestClient, times(1)).save(newQuestion);

    }

    @Test
    void findById() {
        Long id = 1L;
        when(englishTestClient.findEnglishTestById(id)).thenReturn(makeExpEnglishTest());
        EnglishTest actual = englishTestService.findById(id);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpEnglishTest());
    }

    @Test
    void deleteById() {
        Long id = 1L;
        englishTestClient.deleteById(id);
        verify(englishTestClient, times(1)).deleteById(id);

    }

    @Test
    void updateDataInTest() {
        englishTestService.updateDataInTest(makeExpEnglishTest());
        verify(englishTestClient, times(1)).updateDataInTest(makeExpEnglishTest());


    }
}