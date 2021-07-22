package com.example.web_school_manager.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.example.web_school_manager.bean.TgUser;

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
                TgUser[].class)).thenReturn(makeMockedResponseEntity());
        List<TgUser> actual = userClient.findAll();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpectedUsers());
    }

    private List<TgUser> makeExpectedUsers() {
        return List.of(
                TgUser.builder().id(1L).userName("max").build(),
                TgUser.builder().id(2L).userName("bax").build());
    }

    private TgUser[] makeMockedUsers() {
        TgUser[] tgUsers = {
                TgUser.builder().id(1L).userName("max").build(),
                TgUser.builder().id(2L).userName("bax").build()
        };
        return tgUsers;
    }

    private ResponseEntity<TgUser[]> makeMockedResponseEntity() {
        return new ResponseEntity<TgUser[]>(makeMockedUsers(), HttpStatus.OK);
    }
}