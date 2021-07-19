package com.example.web_school_manager.dao.service;

import com.example.web_school_manager.bean.EnglishTest;
import com.example.web_school_manager.client.EnglishTestClient;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class EnglishTestService {

    private final EnglishTestClient englishTestClient;

    public EnglishTestService(EnglishTestClient englishTestClient) {
        this.englishTestClient = englishTestClient;
    }


    public List<EnglishTest> findAll() {
        return englishTestClient.findAll();
    }

    public void addToDb(EnglishTest newQuestion) {
        englishTestClient.save(newQuestion);
    }

    public EnglishTest findById(Long id) {
        return englishTestClient.findEnglishTestById(id);
    }

    public void deleteById(Long id) {
        englishTestClient.deleteById(id);
    }

    public void updateDataInTest(Long id, String question, String firstAnswer, String secondAnswer,
                                 String thirdAnswer, String fourthAnswer, String rightAnswer) {
        englishTestClient.updateDataInTest(id, question, firstAnswer, secondAnswer,
                thirdAnswer, fourthAnswer, rightAnswer);
    }
}
