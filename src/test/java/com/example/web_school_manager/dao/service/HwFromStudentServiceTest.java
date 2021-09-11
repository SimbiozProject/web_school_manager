package com.example.web_school_manager.dao.service;

import com.example.web_school_manager.bean.HwFromStudent;
import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.client.HwFromStudentClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class HwFromStudentServiceTest {

    @Autowired
    HwFromStudentService hwFromStudentService;

    @MockBean
    HwFromStudentClient hwFromStudentClient;

    @MockBean
    HwFromStudent hwFromStudent;

    @MockBean
    TgUser tgUser;

    private List<HwFromStudent> hwFromStudentList;
    private Long id;
    private String firstName;
    private String lastName;
    private int lessonNumber;

    @BeforeEach
    void setup() {
        hwFromStudent = HwFromStudent.builder()
                .studentId(1L)
                .studentName(TgUser.builder().firstName("max").lastName("bax").build())
                .lessonNumber(1)
                .hwFromStudent("nikolaevich")
                .build();
        hwFromStudentList = List.of(
                HwFromStudent.builder()
                        .studentId(1L)
                        .studentName(TgUser.builder().firstName("vova").build())
                        .lessonNumber(1)
                        .hwFromStudent("nikolaevich")
                        .build(),
                HwFromStudent.builder()
                        .studentId(2L)
                        .studentName(TgUser.builder().firstName("vasia").build())
                        .lessonNumber(2)
                        .hwFromStudent("orepri")
                        .build());

        id = hwFromStudent.getStudentId();
        firstName = hwFromStudent.getStudentName().getFirstName();
        lastName = hwFromStudent.getStudentName().getLastName();
        lessonNumber = hwFromStudent.getLessonNumber();
    }

    @Test
    void findAll() {
        when(hwFromStudentClient.findAll()).thenReturn(hwFromStudentList);
        List<HwFromStudent> actual = hwFromStudentService.findAll();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(hwFromStudentList);
    }

    @Test
    void findById() {
        when(hwFromStudentClient.findById(id)).thenReturn(hwFromStudent);
        HwFromStudent actual = hwFromStudentService.findById(id);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(hwFromStudent);
    }

    @Test
    void findByFirstName() {
        when(hwFromStudentClient.findByFirstname(firstName)).thenReturn(hwFromStudentList);
        List<HwFromStudent> actual = hwFromStudentService.findByFirstName(firstName);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(hwFromStudentList);
    }

    @Test
    void findByLastName() {
        when(hwFromStudentClient.findByLastname(lastName)).thenReturn(hwFromStudentList);
        List<HwFromStudent> actual = hwFromStudentService.findByLastName(lastName);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(hwFromStudentList);
    }

    @Test
    void findByLesson() {
        when(hwFromStudentClient.findByLessonNumber(lessonNumber)).thenReturn(hwFromStudentList);
        List<HwFromStudent> actual = hwFromStudentService.findByLesson(lessonNumber);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(hwFromStudentList);
    }

    @Test
    void deleteById() {
        doAnswer((i) -> {
            assertEquals(id, i.getArgument(0));
            return new IllegalArgumentException("This id isn't exist");
        }).when(hwFromStudentClient).deleteById(id);
        hwFromStudentService.deleteById(id);
        verify(hwFromStudentClient, times(1)).deleteById(id);
    }
}