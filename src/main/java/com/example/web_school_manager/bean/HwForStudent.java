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
public class HwForStudent implements Serializable {

    private int hwForStudentsId;

    private Group groupHwForStudents;

    private int lessonNumber;

    private String hwDoc;
}
