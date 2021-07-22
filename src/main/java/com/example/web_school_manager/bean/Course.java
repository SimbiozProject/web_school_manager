package com.example.web_school_manager.bean;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Course implements Serializable {

    private Long courseId;

    private String courseName;


}
