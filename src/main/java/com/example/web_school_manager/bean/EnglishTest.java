package com.example.web_school_manager.bean;

import java.io.Serializable;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor

@Getter
@Setter
@ToString(exclude = "answerFromUser")
@NoArgsConstructor

public class EnglishTest implements Serializable {

    private Long id;

    private String question;

    private String firstAnswer;

    private String secondAnswer;

    private String thirdAnswer;

    private String fourthAnswer;

    private String rightAnswer;

    private Set<UsersAnswer> answerFromUser;

    public EnglishTest(String question, String firstAnswer, String secondAnswer, String thirdAnswer, String fourthAnswer, String rightAnswer) {
        this.question = question;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.fourthAnswer = fourthAnswer;
        this.rightAnswer = rightAnswer;
    }

}
