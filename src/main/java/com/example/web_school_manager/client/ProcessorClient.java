package com.example.web_school_manager.client;

import com.example.web_school_manager.bean.TgUser;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ProcessorClient {
    @Value("${client.processor}")
    private String uri;
    private final RestTemplate restTemplate;

    private String generateUserCode = "/login";

    public void generateUserCode(final String username) throws Exception {
        restTemplate.getForEntity(String.format("%s%s/%s", uri, generateUserCode, username), Void.class);
    }

    public void validateUserCode(String usercode, final String userName) throws Exception {
        restTemplate.postForEntity(String.format("%s%s/%s", uri, generateUserCode, userName), usercode, Void.class);
    }
}
