package com.example.web_school_manager.client;

import com.example.web_school_manager.bean.UsersAnswer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.example.util.UserAnswerUtil.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserAnswerClientTest {

    @Autowired
    UserAnswerClient userAnswerClient;

    @MockBean
    RestTemplate restTemplate;

    @Test
    void findAll() {
        when(restTemplate.getForEntity(
                "http://127.0.0.2:8080/allUsersTest",
                UsersAnswer[].class
        )).thenReturn(makeMockedResponseEntityWithListUsersAnswer());
        List<UsersAnswer> actual = userAnswerClient.findAll();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExampleListUsersAnswer());
    }

    @Test
    void findByUserName() {
        String userName = makeExampleUserAnswer().getUserName().getUserName();
        when(restTemplate.getForEntity(
                String.format("http://127.0.0.2:8080/searchByUserName/%s", userName),
                UsersAnswer.class
        )).thenReturn(makeMockedResponseEntityWithUsersAnswer());
        UsersAnswer actual = userAnswerClient.findByUserName(userName);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExampleUserAnswer());
    }

    @Test
    void findById() {
        Long id = makeExampleUserAnswer().getId();
        when(restTemplate.getForEntity(
                String.format("http://127.0.0.2:8080/searchById/%d", id),
                UsersAnswer.class
        )).thenReturn(makeMockedResponseEntityWithUsersAnswer());
        UsersAnswer actual = userAnswerClient.findById(id).get();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExampleUserAnswer());
    }
}