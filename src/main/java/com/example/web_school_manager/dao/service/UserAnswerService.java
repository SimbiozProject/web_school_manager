package com.example.web_school_manager.dao.service;

import com.example.web_school_manager.bean.UsersAnswer;
import com.example.web_school_manager.dao.repository.UserAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAnswerService {

    @Autowired
    private UserAnswerRepository userAnswerRepository;

    public Iterable<UsersAnswer> findAll() {
        return userAnswerRepository.findAll();
    }

    public UsersAnswer findByUserName(String userName) {
        return userAnswerRepository.findByUserName(userName);
    }

    public Optional<UsersAnswer> findById(Long id) {
        return userAnswerRepository.findById(id);
    }
}
