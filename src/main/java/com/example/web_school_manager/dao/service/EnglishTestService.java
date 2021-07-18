package com.example.web_school_manager.dao.service;

import com.example.web_school_manager.bean.EnglishTest;
import com.example.web_school_manager.dao.repository.EnglishTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnglishTestService {

    @Autowired
    private EnglishTestRepository englishTestRepository;

    public List<EnglishTest> findAll() {
        return englishTestRepository.findAll();
    }

    public void addToDb(EnglishTest newQuestion) {
        englishTestRepository.save(newQuestion);
    }

    public EnglishTest findById(Long id) {
        return englishTestRepository.findEnglishTestById(id);
    }

    public void deleteById(Long id) {
        englishTestRepository.deleteById(id);
    }

    public void updateDataInTest(Long id, String question, String firstAnswer, String secondAnswer,
                                 String thirdAnswer, String fourthAnswer, String rightAnswer) {
        englishTestRepository.updateDataInTest(id, question, firstAnswer, secondAnswer,
                thirdAnswer, fourthAnswer, rightAnswer);
    }
}
