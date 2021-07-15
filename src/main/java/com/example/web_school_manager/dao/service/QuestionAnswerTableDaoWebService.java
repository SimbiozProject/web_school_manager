package com.example.web_school_manager.dao.service;

import com.example.web_school_manager.bean.QuestionAnswerTable;
import com.example.web_school_manager.dao.repository.QuestionAnswerTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuestionAnswerTableDaoWebService {

    private final QuestionAnswerTableRepository questionAnswerTableRepository;

    public QuestionAnswerTableDaoWebService(QuestionAnswerTableRepository questionAnswerTableRepository) {
        this.questionAnswerTableRepository = questionAnswerTableRepository;
    }

    public List<QuestionAnswerTable> findAll() {
        return questionAnswerTableRepository.findAll();
    }

    public void addToDb(QuestionAnswerTable newQuestion) {
        questionAnswerTableRepository.save(newQuestion);
    }

    public QuestionAnswerTable findById(Long id) {
        return questionAnswerTableRepository.findQuestionAnswerTablesById(id);
    }

    public void deleteById(Long id) {
        questionAnswerTableRepository.deleteById(id);
    }

    public void updateDataInTest(Long id, String question, String firstAnswer, String secondAnswer,
                                 String thirdAnswer, String fourthAnswer, String rightAnswer) {
        questionAnswerTableRepository.updateDataInTest(id, question, firstAnswer, secondAnswer,
                thirdAnswer, fourthAnswer, rightAnswer);
    }
}
