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


}
