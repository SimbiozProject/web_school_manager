package com.example.web_school_manager.client;

import com.example.web_school_manager.bean.UsersAnswer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserAnswerClient {

    @Value("${client.processor}")
    private String uri;
    private final RestTemplate restTemplate;

    public List<UsersAnswer> findAll() {
        String userAnswerListPage = "/allUsersTest";
        ResponseEntity<UsersAnswer[]> response =
                restTemplate.getForEntity(
                        String.format("%s%s", uri, userAnswerListPage),
                        UsersAnswer[].class);
        UsersAnswer[] usersAnswers = response.getBody();
        return Arrays.asList(usersAnswers);
    }

    public UsersAnswer findByUserName(String userName) {
        String userAnswerPage = "/searchByUserName/";
        ResponseEntity<UsersAnswer> response =
                restTemplate.getForEntity(
                        String.format("%s%s%s", uri, userAnswerPage, userName),
                        UsersAnswer.class);
        UsersAnswer usersAnswers = response.getBody();
        return usersAnswers;
    }

    public Optional<UsersAnswer> findById(Long id) {
        String idPage = "/searchById/";
        ResponseEntity<UsersAnswer> response =
                restTemplate.getForEntity(
                        String.format("%s%s%d", uri, idPage, id),
                        UsersAnswer.class);
        UsersAnswer usersAnswer = response.getBody();
        return Optional.ofNullable(usersAnswer);
    }

}
