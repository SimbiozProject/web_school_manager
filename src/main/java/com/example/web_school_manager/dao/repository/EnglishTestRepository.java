package com.example.web_school_manager.dao.repository;


import com.example.web_school_manager.bean.EnglishTest;
import org.springframework.stereotype.Component;

@Component
public class EnglishTestRepository implements MyJpaRepository<EnglishTest, Long> {

    public EnglishTest findEnglishTestById(Long id) {
        return null;
    }


    public void updateDataInTest(Long id, String question, String firstAnswer, String secondAnswer, String thirdAnswer,
                          String fourthAnswer, String rightAnswer){

    }
}
