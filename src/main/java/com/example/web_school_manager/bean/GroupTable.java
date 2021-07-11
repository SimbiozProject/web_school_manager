package com.example.web_school_manager.bean;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Builder
@Entity
@Table(name = "student_group")
public class GroupTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private Long idGroup;

    @Column(name = "group_number")
    private Long groupNumber;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_name")   // insertable=false, updatable=false)
    private CourseTable groupCourse;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "groupUser")
    private Set<TgUserTable> tgUserSet;

    @OneToMany(mappedBy = "groupHwForStudents", fetch = FetchType.EAGER)
    private Set<HwForStudentTable> studentHw;

    public GroupTable() {
    }

    public GroupTable(Long idGroup, Long groupNumber, CourseTable groupCourse, Set<TgUserTable> tgUserSet, Set<HwForStudentTable> studentHw) {
        this.idGroup = idGroup;
        this.groupNumber = groupNumber;
        this.groupCourse = groupCourse;
        this.tgUserSet = tgUserSet;
        this.studentHw = studentHw;
    }

    public Long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Long idGroup) {
        this.idGroup = idGroup;
    }

    public Long getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Long groupNumber) {
        this.groupNumber = groupNumber;
    }

    public CourseTable getGroupCourse() {
        return groupCourse;
    }

    public void setGroupCourse(CourseTable groupCourse) {
        this.groupCourse = groupCourse;
    }

    public Set<TgUserTable> getTgUserSet() {
        return tgUserSet;
    }

    public void setTgUserSet(Set<TgUserTable> tgUserSet) {
        this.tgUserSet = tgUserSet;
    }

    public Set<HwForStudentTable> getStudentHw() {
        return studentHw;
    }

    public void setStudentHw(Set<HwForStudentTable> studentHw) {
        this.studentHw = studentHw;
    }
}
