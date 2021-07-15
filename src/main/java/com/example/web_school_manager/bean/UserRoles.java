package com.example.web_school_manager.bean;

import java.io.Serializable;

public enum UserRoles implements Serializable {

    ROLE_ADMIN,
    ROLE_USER,
    ROLE_STUDENT,
    ROLE_TEACHER;

    UserRoles() {
    }
}
