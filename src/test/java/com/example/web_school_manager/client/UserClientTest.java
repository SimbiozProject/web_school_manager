package com.example.web_school_manager.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.example.web_school_manager.bean.TgUserTable;
import com.example.web_school_manager.dao.service.AdminService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class UserClientTest {

    @Autowired
    UserClient userClient;
    @MockBean
    RestTemplate restTemplate;

    @Test
    void findAll() {
        when(restTemplate.getForEntity(
                "http://127.0.0.2:8080/users",
                TgUserTable[].class)).thenReturn(makeMockedResponseEntity());
        List<TgUserTable> actual = userClient.findAll();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpectedUsers());
    }

    private List<TgUserTable> makeExpectedUsers() {
        return List.of(
                TgUserTable.builder().id(1L).userName("max").build(),
                TgUserTable.builder().id(2L).userName("bax").build());
    }

    private TgUserTable[] makeMockedUsers() {
        TgUserTable[] tgUserTables = {
                TgUserTable.builder().id(1L).userName("max").build(),
                TgUserTable.builder().id(2L).userName("bax").build()
        };
        return tgUserTables;
    }

    private ResponseEntity<TgUserTable[]> makeMockedResponseEntity() {
        return new ResponseEntity<TgUserTable[]>(makeMockedUsers(), HttpStatus.OK);
    }
}