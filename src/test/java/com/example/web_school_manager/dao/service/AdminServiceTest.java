package com.example.web_school_manager.dao.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.client.UserClient;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class AdminServiceTest {

    @Autowired
    AdminService adminService;
    @MockBean
    UserClient userClient;

    @Test
    void findAllUsers() {
        when(userClient.findAll()).thenReturn(makeExpectedUsers());
        List<TgUser> actual = adminService.findAllUsers();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpectedUsers());
    }

    private List<TgUser> makeExpectedUsers() {
        return List.of(
                TgUser.builder().id(1L).userName("max").build(),
                TgUser.builder().id(2L).userName("bax").build());
    }
}