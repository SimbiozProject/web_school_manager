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
public class EnglishTestClient {
    @Value("${client.processor}")
    private String uri;
    private final RestTemplate restTemplate;

    private final String getListOfTests = "/test";
    private final String postSaveTest = "/addTest";
    private final String update = "/update/";
    private final String delete = "/delete/";
    private final String find = "/find/";


    public List<EnglishTest> findAll() {
        ResponseEntity<EnglishTest[]> response =
                restTemplate.getForEntity(
                        String.format("%s%s", uri, getListOfTests),
                        EnglishTest[].class);
        EnglishTest[] tests = response.getBody();
        return Arrays.asList(tests);
    }

    public void save(EnglishTest newQuestion) {

        restTemplate.postForEntity(
                String.format("%s%s", uri, postSaveTest),
                newQuestion, ResponseEntity.class);
    }

    public EnglishTest findEnglishTestById(Long id) {
        ResponseEntity<EnglishTest> responseUpdate =
                restTemplate.getForEntity(
                        String.format("%s%s%d", uri, update, id),
                        EnglishTest.class);
        EnglishTest testUpdate = responseUpdate.getBody();
        /*ResponseEntity<EnglishTest> responseDelete =
                restTemplate.getForEntity(
                        String.format("%s%s%d", uri, delete, id),
                        EnglishTest.class);
        EnglishTest testDelete = responseDelete.getBody();*/
        return testUpdate;
    }

    public void deleteById(Long id) {
        restTemplate.postForEntity(
                String.format("%s%s%d", uri, delete, id),
                id,
                ResponseEntity.class);
    }

    public void updateDataInTest(EnglishTest updateQuestion) {
        restTemplate.postForEntity(
                String.format("%s%s%d", uri, update, updateQuestion.getId()),
                updateQuestion,
                ResponseEntity.class);
    }

}
