package com.example.web_school_manager.bean;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
@Table(name = "user_answer")
public class UserAnswerTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_name")
    private TgUserTable userName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id", nullable = false)
    private QuestionAnswerTable questionAnswer;

    @Column(name = "answer")
    private String answer;

    public UserAnswerTable() {
    }

    public UserAnswerTable(Long id, TgUserTable userName, QuestionAnswerTable questionAnswer, String answer) {
        this.id = id;
        this.userName = userName;
        this.questionAnswer = questionAnswer;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TgUserTable getUserName() {
        return userName;
    }

    public void setUserName(TgUserTable userName) {
        this.userName = userName;
    }

    public QuestionAnswerTable getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(QuestionAnswerTable questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
