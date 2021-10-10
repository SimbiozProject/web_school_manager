package com.example.web_school_manager.controller.tests;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {
    Long id;
    List<Answer> answerList;
    String created;
    String question;
    Long testId;

    @Data
    static class Answer {
        Long id;
        String answer;
        Boolean correct;

        public Answer(String answer, Boolean correct) {
            this.answer = answer;
            this.correct = correct;
        }
    }
}
