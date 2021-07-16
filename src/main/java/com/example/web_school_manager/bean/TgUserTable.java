package com.example.web_school_manager.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"fromStudent", "usersAnswers"})
public class TgUserTable implements Serializable {

    private Long id;

    private String userName;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private Boolean active;

    private Date dateOfBirthday;

    private UserRoles roles;

    private CourseTable courseUser;

    private GroupTable groupUser;

    private Boolean blockUser;

    private Boolean payment;

    private Set<HwFromStudentTable> fromStudent;

    private Set<UserAnswerTable> usersAnswers;

    public TgUserTable(Long id, String userName, Boolean blockUser) {
        this.id = id;
        this.userName = userName;
        this.blockUser = blockUser;
    }

    public TgUserTable(Long id, Boolean blockUser) {
        this.id = id;
        this.blockUser = blockUser;
    }

    public TgUserTable(String userName) {
        this.userName = userName;
    }
}
