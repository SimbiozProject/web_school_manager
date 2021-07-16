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
@NoArgsConstructor
@ToString(exclude = {"userSet", "groupSet"})
public class CourseTable implements Serializable {

    private Long courseId;

    private String courseName;

    private Set<TgUserTable> userSet;

    private Set<GroupTable> groupSet;

}
