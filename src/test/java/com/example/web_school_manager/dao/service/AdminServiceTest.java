package com.example.web_school_manager.dao.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.example.web_school_manager.bean.TgUserTable;
import com.example.web_school_manager.client.UserClient;
import com.example.web_school_manager.dao.repository.TgUserTableDaoWebRepository;
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
        List<TgUserTable> actual = adminService.findAllUsers();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpectedUsers());
    }

    private List<TgUserTable> makeExpectedUsers() {
        return List.of(
                TgUserTable.builder().id(1L).userName("max").build(),
                TgUserTable.builder().id(2L).userName("bax").build());
    }
}