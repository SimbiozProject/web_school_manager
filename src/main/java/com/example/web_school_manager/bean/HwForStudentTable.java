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
public class HwForStudentTable implements Serializable {

    private int hwForStudentsId;

    private GroupTable groupHwForStudents;

    private int lessonNumber;

    private String hwDoc;
}
