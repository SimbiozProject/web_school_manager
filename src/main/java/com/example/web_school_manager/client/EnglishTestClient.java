package com.example.web_school_manager.client;

import com.example.web_school_manager.bean.EnglishTest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EnglishTestClient  {
    @Value("${client.processor}")
    private String uri;
    private final RestTemplate restTemplate;

    private final String getListOfTests = "/teacher/test";
    private final String getTest = "/teacher/update";




    public List<EnglishTest> findAll() {
        ResponseEntity<EnglishTest[]> response =
                restTemplate.getForEntity(
                        String.format("%s%s", uri, getListOfTests),
                        EnglishTest[].class);
        EnglishTest[] tests = response.getBody();
        return Arrays.asList(tests);
    }

    public void save(EnglishTest newQuestion) {
        ResponseEntity<EnglishTest[]> response =
                restTemplate.getForEntity(
                        String.format("%s%s", uri, getListOfTests),
                        EnglishTest[].class);
        EnglishTest[] tests = response.getBody();

    }

    public EnglishTest findEnglishTestById(Long id) {
        ResponseEntity<EnglishTest> response =
                restTemplate.getForEntity(
                        String.format("%s%s", uri, getListOfTests),
                        EnglishTest.class);
        EnglishTest test = response.getBody();
        return test;
    }

    public void deleteById(Long id) {
        ResponseEntity<EnglishTest[]> response =
                restTemplate.getForEntity(
                        String.format("%s%s", uri, getListOfTests),
                        EnglishTest[].class);
        EnglishTest[] tests = response.getBody();

    }

    public void updateDataInTest(Long id, String question, String firstAnswer, String secondAnswer,
                                              String thirdAnswer, String fourthAnswer, String rightAnswer) {
        ResponseEntity<EnglishTest[]> response =
                restTemplate.getForEntity(
                        String.format("%s%s", uri, getListOfTests),
                        EnglishTest[].class);
        EnglishTest[] tests = response.getBody();

    }

}
