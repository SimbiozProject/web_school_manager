package com.example.web_school_manager.controller;

import com.example.web_school_manager.dao.service.UserAnswerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserAnswerControllerTest {

    @Autowired
    UserAnswerController userAnswerController;

    @MockBean
    UserAnswerService userAnswerService;

    @BeforeEach
    void setup() {

    }

    @Test
    void getAllUserTest() {
//        when(userAnswerService.findAll()).thenReturn()
    }

    @Test
    void searchByUserName() {
    }

    @Test
    void searchById() {
    }
}