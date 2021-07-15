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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class UserClient {
    private final RestTemplate restTemplate;

    public List<TgUserTable> findAll() {
        ResponseEntity<TgUserTable[]> response =
                restTemplate.getForEntity(
                        "http://localhost:8080/employees/",
                        TgUserTable[].class);
        TgUserTable[] users = response.getBody();
        return Arrays.asList(users);
    }
}