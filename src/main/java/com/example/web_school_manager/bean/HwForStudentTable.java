package com.example.web_school_manager.bean;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
@Table(name = "hw_for_students")
public class HwForStudentTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hw_id")
    private int hwForStudentsId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_number")
    private GroupTable groupHwForStudents;

    @Column(name = "lesson_number")
    private int lessonNumber;

    @Column(name = "hw_doc")
    private String hwDoc;

    public HwForStudentTable() {
    }

    public HwForStudentTable(int hwForStudentsId, GroupTable groupHwForStudents, int lessonNumber, String hwDoc) {
        this.hwForStudentsId = hwForStudentsId;
        this.groupHwForStudents = groupHwForStudents;
        this.lessonNumber = lessonNumber;
        this.hwDoc = hwDoc;
    }

    public int getHwForStudentsId() {
        return hwForStudentsId;
    }

    public void setHwForStudentsId(int hwForStudentsId) {
        this.hwForStudentsId = hwForStudentsId;
    }

    public GroupTable getGroupHwForStudents() {
        return groupHwForStudents;
    }

    public void setGroupHwForStudents(GroupTable groupHwForStudents) {
        this.groupHwForStudents = groupHwForStudents;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public String getHwDoc() {
        return hwDoc;
    }

    public void setHwDoc(String hwDoc) {
        this.hwDoc = hwDoc;
    }
}
