package com.example.web_school_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class QuestionAnswerDto {
    String question;
    String firstAnswer;
    String secondAnswer;
    String thirdAnswer;
    String fourthAnswer;
    String rightAnswer;
}
