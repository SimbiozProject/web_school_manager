package com.example.web_school_manager.dao.service;

import com.example.web_school_manager.bean.UsersAnswer;
import com.example.web_school_manager.client.UserAnswerClient;
import com.example.web_school_manager.dao.repository.UserAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAnswerService {

    @Autowired
    private UserAnswerClient userAnswerClient;

    public List<UsersAnswer> findAll() {
        return userAnswerClient.findAll();
    }

    public UsersAnswer findByUserName(String userName) {
        return userAnswerClient.findByUserName(userName);
    }

    public Optional<UsersAnswer> findById(Long id) {
        return userAnswerClient.findById(id);
    }
}
