package com.example.web_school_manager.client;

import com.example.web_school_manager.bean.HwFromStudent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.example.util.HwFromStudentUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

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
        Long id = 1L;
        hwFromStudentClient.deleteById(id);
        verify(restTemplate, times(1))
                .postForEntity(String.format("http://127.0.0.2:8080/deleteHwFromStudent/%d", id), id,
                ResponseEntity.class);
    }

    @Test
    void findByLastname() {
        String lastname = "Ann";
        when(restTemplate.getForEntity(
                String.format("http://127.0.0.2:8080/findByLastname/%s", lastname),
                HwFromStudent[].class)).thenReturn(makeMockedResponseEntityWithList());
        List<HwFromStudent> actual = hwFromStudentClient.findByLastname(lastname);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpHwList());
    }

    @Test
    void findByFirstname() {
        String firstname = "Boo";
        when(restTemplate.getForEntity(
                String.format("http://127.0.0.2:8080/findByFirstname/%s", firstname),
                HwFromStudent[].class)).thenReturn(makeMockedResponseEntityWithList());
        List<HwFromStudent> actual = hwFromStudentClient.findByFirstname(firstname);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpHwList());
    }

    @Test
    void findByLesson() {
        Integer lesson = 1;
        when(restTemplate.getForEntity(
                String.format("http://127.0.0.2:8080/findByLessonNumber/%d", lesson),
                HwFromStudent[].class)).thenReturn(makeMockedResponseEntityWithList());
        List<HwFromStudent> actual = hwFromStudentClient.findByLessonNumber(lesson);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpHwList());
    }

    @Test
    void findHwById() {
        Long id = 1L;
        when(restTemplate.getForEntity(
                String.format("http://127.0.0.2:8080/findHwById/%d", id),
                HwFromStudent.class)).thenReturn(makeMockedResponseEntityWithHw());
        HwFromStudent actual = hwFromStudentClient.findById(id);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpHw());
    }

}