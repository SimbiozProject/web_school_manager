package com.example.web_school_manager.dao.repository;

import com.example.web_school_manager.bean.Course;
import com.example.web_school_manager.bean.Group;
import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.bean.Roles;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class TgUserRepository implements MyJpaRepository<TgUser, Long> {

    public Optional<TgUser> findByUserName(String userName) {
        return null;
    }

    public Optional<TgUser> findByFirstName(String userName) {
        return null;
    }

    public Optional<TgUser> findByLastName(String userName) {
        return null;
    }

    public TgUser findByEmail(String email) {
        return null;
    }

    public List<TgUser> findTgUserTableByBlockUserIsTrue() {
        return null;
    }

    public void deleteTgUserTableById(Long id) {

    }

    public Optional<TgUser> findTgUserTableById(Long id) {
        return null;
    }

    public void updateBlockUserStatus(Long id, Boolean blockUser) {

    }

    public void updateUsersData(Long id, String userName, String firstName, String lastName, String email,
                                Date dateOfBirthday, Boolean active, Boolean blockUser, Boolean payment,
                                Roles roles, Course courseUser, Group groupUser) {

    }
}