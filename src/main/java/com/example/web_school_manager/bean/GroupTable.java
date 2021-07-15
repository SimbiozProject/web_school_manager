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
@ToString(exclude = {"tgUserSet", "studentHw"})
public class GroupTable implements Serializable {

    private Long idGroup;

    private Long groupNumber;

    private CourseTable groupCourse;

    private Set<TgUserTable> tgUserSet;

    private Set<HwForStudentTable> studentHw;

}
