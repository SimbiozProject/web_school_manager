package com.example.web_school_manager.dao.repository;

import com.example.web_school_manager.bean.CourseTable;
import com.example.web_school_manager.bean.GroupTable;
import com.example.web_school_manager.bean.TgUserTable;
import com.example.web_school_manager.bean.UserRoles;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class TgUserTableDaoWebRepository implements MyJpaRepository<TgUserTable, Long> {

    public Optional<TgUserTable> findByUserName(String userName) {
        return null;
    }

    public Optional<TgUserTable> findByFirstName(String userName) {
        return null;
    }

    public Optional<TgUserTable> findByLastName(String userName) {
        return null;
    }

    public TgUserTable findByEmail(String email) {
        return null;
    }

    public List<TgUserTable> findTgUserTableByBlockUserIsTrue() {
        return null;
    }

    public void deleteTgUserTableById(Long id) {

    }

    public Optional<TgUserTable> findTgUserTableById(Long id) {
        return null;
    }

    public void updateBlockUserStatus(Long id, Boolean blockUser) {

    }

    public void updateUsersData(Long id, String userName, String firstName, String lastName, String email,
                         Date dateOfBirthday, Boolean active, Boolean blockUser, Boolean payment,
                         UserRoles roles, CourseTable courseUser, GroupTable groupUser) {

    }
}