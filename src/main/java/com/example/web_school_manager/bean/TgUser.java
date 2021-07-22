package com.example.web_school_manager.bean;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TgUser implements Serializable {

    public TgUser(Long id, String userName, Boolean blockUser) {
        this.id = id;
        this.userName = userName;
        this.blockUser = blockUser;
    }

    public TgUser(Long id, Boolean blockUser) {
        this.id = id;
        this.blockUser = blockUser;
    }

    public TgUser(Long id, String userName, String email, Boolean active, Boolean blockUser, Boolean payment) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.active = active;
        this.blockUser = blockUser;
        this.payment = payment;
    }

    public TgUser(String userName) {
        this.userName = userName;
    }

    private Long id;

    private String userName;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private Boolean active;

    private Date dateOfBirthday;

    private Roles roles;

    private Course courseUser;

    private Group groupUser;

    private Boolean blockUser;

    private Boolean payment;

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getActive() {
        return active;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public Roles getRoles() {
        return roles;
    }

    public Course getCourseUser() {
        return courseUser;
    }

    public Group getGroupUser() {
        return groupUser;
    }

    public Boolean getBlockUser() {
        return blockUser;
    }

    public Boolean getPayment() {
        return payment;
    }
}
