package com.example.web_school_manager.client;

import com.example.web_school_manager.bean.EnglishTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.example.util.EnglishTestUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class EnglishTestClientTest {

    @Autowired
    EnglishTestClient englishTestClient;
    @MockBean
    RestTemplate restTemplate;

    @Test
    void findAll() {
        when(restTemplate.getForEntity(
                "http://127.0.0.2:8080/test",
                EnglishTest[].class)).thenReturn(makeMockedResponseEntityWithList());
        List<EnglishTest> actual = englishTestClient.findAll();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpList());
    }

    /*
     *РАзные методы писать на файнд by id? или вызывать с разных урлов в одном методе, сравнивать и если одинаков то отправлять?
     * если возврат нала невозможен в прогамме, а в тесте возможен как быть? Заворачивать в опшнал все равно? или не проверять на налл?
     */

    @Test
    void save() {
        EnglishTest newQuestion = makeExpEnglishTest();
        englishTestClient.save(newQuestion);
        verify(restTemplate, times(1)).postForEntity("http://127.0.0.2:8080/addTest", newQuestion,
                ResponseEntity.class);
    }


    @Test
    void findEnglishTestById() {
        Long id = 1L;
        when(restTemplate.getForEntity(
                String.format("http://127.0.0.2:8080/update/%d", id),
                EnglishTest.class)).thenReturn(makeMockedResponseEntityWithTest());
        EnglishTest actual = englishTestClient.findEnglishTestById(id);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpEnglishTest());
    }

    @Test
    void deleteById() {
        Long id = 1L;
        englishTestClient.deleteById(id);
        verify(restTemplate, times(1)).postForEntity(String.format("http://127.0.0.2:8080/delete/%d", id), id,
                ResponseEntity.class);
    }

    @Test
    void updateDataInTest() {
        EnglishTest updateQ = makeExpEnglishTest();
        Long id = 1L;
        englishTestClient.updateDataInTest(updateQ);
        verify(restTemplate, times(1)).postForEntity(String.format("http://127.0.0.2:8080/update/%d", id), updateQ,
                ResponseEntity.class);
    }
}