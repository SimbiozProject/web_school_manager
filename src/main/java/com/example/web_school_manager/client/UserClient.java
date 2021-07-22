package com.example.web_school_manager.client;

import com.example.web_school_manager.bean.TgUser;

import java.util.Arrays;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class UserClient {
    @Value("${client.processor}")
    private String uri;
    private final RestTemplate restTemplate;

    private String getAllUsers = "/users";

    public List<TgUser> findAll() {
        ResponseEntity<TgUser[]> response =
                restTemplate.getForEntity(
                        String.format("%s%s", uri, getAllUsers),
                        TgUser[].class);
        TgUser[] users = response.getBody();
        return Arrays.asList(users);
    }
}