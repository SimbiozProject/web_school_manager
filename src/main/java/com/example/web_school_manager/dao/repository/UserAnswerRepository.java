package com.example.web_school_manager.dao.repository;

import com.example.web_school_manager.bean.UsersAnswer;
import org.springframework.stereotype.Component;

@Component
public class UserAnswerRepository implements MyJpaRepository<UsersAnswer, Long> {

    public UsersAnswer findByUserName(String userName){
        return null;
    }
}
