package com.example.web_school_manager.client;

import com.example.web_school_manager.bean.CourseTable;
import com.example.web_school_manager.bean.GroupTable;
import com.example.web_school_manager.bean.TgUserTable;
import com.example.web_school_manager.bean.UserRoles;
import com.example.web_school_manager.dao.repository.MyJpaRepository;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

    public List<TgUserTable> findAll() {
        ResponseEntity<TgUserTable[]> response =
                restTemplate.getForEntity(
                        String.format("%s%s", uri, getAllUsers),
                        TgUserTable[].class);
        TgUserTable[] users = response.getBody();
        return Arrays.asList(users);
    }
}