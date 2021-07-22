package com.example.web_school_manager.bean;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Group implements Serializable {

    private Long idGroup;

    private Long groupNumber;

    private Course groupCourse;


}
