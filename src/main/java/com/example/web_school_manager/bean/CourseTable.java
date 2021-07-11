package com.example.web_school_manager.bean;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Builder
@Entity
@Table(name = "courses")
public class CourseTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_name")
    private String courseName;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "courseUser")
    private Set<TgUserTable> userSet;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "groupCourse")
    private Set<GroupTable> groupSet;

    public CourseTable() {
    }

    public CourseTable(Long courseId, String courseName, Set<TgUserTable> userSet, Set<GroupTable> groupSet) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.userSet = userSet;
        this.groupSet = groupSet;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Set<TgUserTable> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<TgUserTable> userSet) {
        this.userSet = userSet;
    }

    public Set<GroupTable> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<GroupTable> groupSet) {
        this.groupSet = groupSet;
    }
}
