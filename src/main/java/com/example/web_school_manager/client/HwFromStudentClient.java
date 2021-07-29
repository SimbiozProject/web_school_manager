package com.example.web_school_manager.client;


import com.example.web_school_manager.bean.EnglishTest;
import com.example.web_school_manager.bean.HwFromStudent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class HwFromStudentClient {
    @Value("${client.processor}")
    private String uri;
    private final RestTemplate restTemplate;

    private final String getListOfHw = "/teacherCheckHw";
    private final String delete = "/deleteHwFromStudent/";
    private final String find = "/find/";

    public List<HwFromStudent> findAll() {
        ResponseEntity<HwFromStudent[]> response =
                restTemplate.getForEntity(
                        String.format("%s%s", uri, getListOfHw),
                        HwFromStudent[].class);
        HwFromStudent[] hw = response.getBody();
        return Arrays.asList(hw);
    }

    public void deleteById(Long id) {
        restTemplate.postForEntity(String.format("%s%s%d", uri, delete, id),
                id, ResponseEntity.class);
    }
}
