package com.example.web_school_manager.bean;

import java.io.Serializable;
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
@ToString
@NoArgsConstructor
public class HwFromStudentTable implements Serializable {

    private Long studentId;

    private TgUserTable studentName;

    private int lessonNumber;

    private String hwFromStudent;

}
