package com.example.web_school_manager.dao.repository;

import com.example.web_school_manager.bean.UsersAnswer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserAnswerRepository implements MyJpaRepository<UsersAnswer, Long> {

    public UsersAnswer findByUserName(String userName){
        return null;
    }

    public Optional<UsersAnswer> findById(Long id) {
        return Optional.empty();
    }

    public List<UsersAnswer> findAll() {
        return null;
    }
}
