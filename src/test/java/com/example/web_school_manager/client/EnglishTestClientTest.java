package com.example.web_school_manager.client;

import com.example.web_school_manager.bean.EnglishTest;
import com.example.web_school_manager.bean.TgUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.example.util.EnglishTestUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class EnglishTestClientTest {

    @Autowired
    EnglishTestClient englishTestClient;
    @MockBean
    RestTemplate restTemplate;

    @Test
    void findAll() {
        when(restTemplate.getForEntity(
                "http://127.0.0.2:8080/teacher/test",
                EnglishTest[].class)).thenReturn(makeMockedResponseEntity());
        List<EnglishTest> actual = englishTestClient.findAll();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpList());
    }



    @Test
    void save() {
    }

    @Test
    void findEnglishTestById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void updateDataInTest() {
    }
}