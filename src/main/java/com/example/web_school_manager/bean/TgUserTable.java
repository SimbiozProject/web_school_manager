package com.example.web_school_manager.bean;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Builder
@Entity
@Table(name = "tg_user")
public class TgUserTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "date_of_birthday")
    private Date dateOfBirthday;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRoles roles;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_name")     // insertable=false, updatable=false)
    private CourseTable courseUser;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_number") // insertable=false, updatable=false)
    private GroupTable groupUser;

    @Column(name = "block_user")
    private Boolean blockUser;

    @Column(name = "payment")
    private Boolean payment;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "studentName", cascade = CascadeType.REMOVE)
    private HwFromStudentTable fromStudent;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "userName", cascade = CascadeType.REMOVE)
    private UserAnswerTable usersAnswers;

    public TgUserTable() {
    }

    public TgUserTable(Long id, String userName, String firstName, String lastName, String email, Boolean active, Date dateOfBirthday, UserRoles roles, CourseTable courseUser, GroupTable groupUser, Boolean blockUser, Boolean payment, HwFromStudentTable fromStudent, UserAnswerTable usersAnswers) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.dateOfBirthday = dateOfBirthday;
        this.roles = roles;
        this.courseUser = courseUser;
        this.groupUser = groupUser;
        this.blockUser = blockUser;
        this.payment = payment;
        this.fromStudent = fromStudent;
        this.usersAnswers = usersAnswers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public UserRoles getRoles() {
        return roles;
    }

    public void setRoles(UserRoles roles) {
        this.roles = roles;
    }

    public CourseTable getCourseUser() {
        return courseUser;
    }

    public void setCourseUser(CourseTable courseUser) {
        this.courseUser = courseUser;
    }

    public GroupTable getGroupUser() {
        return groupUser;
    }

    public void setGroupUser(GroupTable groupUser) {
        this.groupUser = groupUser;
    }

    public Boolean getBlockUser() {
        return blockUser;
    }

    public void setBlockUser(Boolean blockUser) {
        this.blockUser = blockUser;
    }

    public Boolean getPayment() {
        return payment;
    }

    public void setPayment(Boolean payment) {
        this.payment = payment;
    }

    public HwFromStudentTable getFromStudent() {
        return fromStudent;
    }

    public void setFromStudent(HwFromStudentTable fromStudent) {
        this.fromStudent = fromStudent;
    }

    public UserAnswerTable getUsersAnswers() {
        return usersAnswers;
    }

    public void setUsersAnswers(UserAnswerTable usersAnswers) {
        this.usersAnswers = usersAnswers;
    }
}
