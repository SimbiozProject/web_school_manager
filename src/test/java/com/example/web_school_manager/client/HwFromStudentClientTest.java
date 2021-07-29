package com.example.web_school_manager.client;

import com.example.web_school_manager.bean.HwFromStudent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.example.util.HwFromStudentUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class HwFromStudentClientTest {

    @Autowired
    HwFromStudentClient hwFromStudentClient;
    @MockBean
    RestTemplate restTemplate;

    @Test
    void findAll() {
        when(restTemplate.getForEntity(
                "http://127.0.0.2:8080/teacherCheckHw",
                HwFromStudent[].class)).thenReturn(makeMockedResponseEntityWithList());
        List<HwFromStudent> actual = hwFromStudentClient.findAll();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpHwList());
    }

    @Test
    void deleteById() {
    }
}