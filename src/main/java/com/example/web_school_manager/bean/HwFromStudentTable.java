package com.example.web_school_manager.bean;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
@Table(name = "hwFrom_students")
public class HwFromStudentTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private int studentId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "student_name")
    private TgUserTable studentName;

    @Column(name = "lesson_number")
    private int lessonNumber;

    @Column(name = "students_hw")
    private String hwFromStudent;

    public HwFromStudentTable() {
    }

    public HwFromStudentTable(int studentId, TgUserTable studentName, int lessonNumber, String hwFromStudent) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.lessonNumber = lessonNumber;
        this.hwFromStudent = hwFromStudent;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public TgUserTable getStudentName() {
        return studentName;
    }

    public void setStudentName(TgUserTable studentName) {
        this.studentName = studentName;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public String getHwFromStudent() {
        return hwFromStudent;
    }

    public void setHwFromStudent(String hwFromStudent) {
        this.hwFromStudent = hwFromStudent;
    }
}
