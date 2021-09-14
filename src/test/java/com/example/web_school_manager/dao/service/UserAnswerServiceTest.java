package com.example.web_school_manager.dao.service;

import com.example.web_school_manager.dao.repository.UserAnswerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserAnswerServiceTest {

    @Autowired
    UserAnswerService userAnswerService;

    @MockBean
    UserAnswerRepository userAnswerRepository;



    @BeforeEach
    void setup() {

    }

    @Test
    void findAll() {
    }

    @Test
    void findByUserName() {
    }

    @Test
    void findById() {
    }
}