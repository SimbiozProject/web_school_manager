package com.example.web_school_manager.dao.repository;

import com.example.web_school_manager.bean.UserAnswerTable;
import org.springframework.stereotype.Component;

@Component
public class UserAnswerRepository implements MyJpaRepository<UserAnswerTable, Long> {

    public UserAnswerTable findByUserName(String userName){
        return null;
    }
}
