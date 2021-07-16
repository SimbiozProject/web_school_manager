package com.example.web_school_manager.bean;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor

@Getter
@Setter
@NoArgsConstructor

public class EnglishTest implements Serializable {

    public EnglishTest(String question, String firstAnswer, String secondAnswer, String thirdAnswer, String fourthAnswer, String rightAnswer) {
        this.question = question;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.fourthAnswer = fourthAnswer;
        this.rightAnswer = rightAnswer;
    }

    private Long id;

    private String question;

    private String firstAnswer;

    private String secondAnswer;

    private String thirdAnswer;

    private String fourthAnswer;

    private String rightAnswer;


}
