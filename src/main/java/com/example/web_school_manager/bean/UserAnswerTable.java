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

public class UserAnswerTable  implements Serializable {

    private Long id;

    private TgUserTable userName;

    private QuestionAnswerTable questionAnswer;

    private String answer;

}
