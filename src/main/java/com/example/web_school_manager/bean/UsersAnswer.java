package com.example.web_school_manager.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor

@NoArgsConstructor

public class UsersAnswer implements Serializable {

    private Long id;

    private TgUser userName;

    private EnglishTest questionAnswer;

    private String answer;

}
