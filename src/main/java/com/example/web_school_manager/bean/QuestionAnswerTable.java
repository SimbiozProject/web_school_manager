package com.example.web_school_manager.bean;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Builder
@Entity
@Table(name = "question_answer")
public class QuestionAnswerTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "question")
    private String question;

    @Column(name = "first_answer")
    private String firstAnswer;

    @Column(name = "second_answer")
    private String secondAnswer;

    @Column(name = "third_answer")
    private String thirdAnswer;

    @Column(name = "fourth_answer")
    private String fourthAnswer;

    @Column(name = "right_answer")
    private String rightAnswer;

    @OneToMany(mappedBy = "questionAnswer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
    private Set<UserAnswerTable> answerFromUser;

    public QuestionAnswerTable() {
    }

    public QuestionAnswerTable(Long id, String question, String firstAnswer, String secondAnswer, String thirdAnswer, String fourthAnswer, String rightAnswer, Set<UserAnswerTable> answerFromUser) {
        this.id = id;
        this.question = question;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.fourthAnswer = fourthAnswer;
        this.rightAnswer = rightAnswer;
        this.answerFromUser = answerFromUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
