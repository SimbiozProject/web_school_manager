package com.example.web_school_manager.dao.service;

import com.example.web_school_manager.bean.UsersAnswer;
import com.example.web_school_manager.client.UserAnswerClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static com.example.util.UserAnswerUtil.makeExampleListUsersAnswer;
import static com.example.util.UserAnswerUtil.makeExampleUserAnswer;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserAnswerServiceTest {

    @Autowired
    UserAnswerService userAnswerService;

    @MockBean
    UserAnswerClient userAnswerClient;

    @Test
    void findAll() {
        when(userAnswerClient.findAll()).thenReturn(makeExampleListUsersAnswer());
        List<UsersAnswer> actual = userAnswerService.findAll();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExampleListUsersAnswer());
    }

    @Test
    void findByUserName() {
        String userName = makeExampleUserAnswer().getUserName().getUserName();
        when(userAnswerClient.findByUserName(userName)).thenReturn(makeExampleUserAnswer());
        UsersAnswer actual = userAnswerService.findByUserName(userName);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExampleUserAnswer());
    }

    @Test
    void findById() {
        Long id = makeExampleUserAnswer().getId();
        when(userAnswerClient.findById(id)).thenReturn(Optional.ofNullable(makeExampleUserAnswer()));
        UsersAnswer actual = userAnswerService.findById(id).get();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExampleUserAnswer());
    }
}