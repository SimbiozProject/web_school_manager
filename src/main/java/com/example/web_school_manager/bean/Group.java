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
public class Group implements Serializable {

    private Long idGroup;

    private Long groupNumber;

    private Course groupCourse;

    private Set<TgUser> tgUserSet;

    private Set<HwForStudent> studentHw;

}
