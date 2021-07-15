package com.example.web_school_manager.dao.repository;


import com.example.web_school_manager.bean.QuestionAnswerTable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class QuestionAnswerTableRepository implements MyJpaRepository<QuestionAnswerTable, Long> {

    public QuestionAnswerTable findQuestionAnswerTablesById(Long id) {
        return null;
    }

    public void updateDataInTest(Long id, String question, String firstAnswer, String secondAnswer, String thirdAnswer,
                          String fourthAnswer, String rightAnswer){

    }
}
