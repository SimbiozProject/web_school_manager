package com.example.web_school_manager.controller;

import com.example.web_school_manager.dao.repository.HwFromStudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TeacherCheckHwControllerIntTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    HwFromStudentRepository hwFromStudentRepository;

    @Autowired
    TeacherCheckHwController teacherCheckHwController;

    @Test
    void checkingHwPage() throws Exception {
        //RequestBuilder request = MockMvcRequestBuilders.get("/allHW");
        //mockMvc.perform(request).andDo(print()).andExpect(status().isOk());

        RequestBuilder request = MockMvcRequestBuilders.get("/allHw")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(teacherCheckHwController.checkingHwPage()));

        var expected = teacherCheckHwController.checkingHwPage();

        MvcResult result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expected), false))
                .andReturn();
    }

    @Test
    void deleteHwFrom() {
    }

    @Test
    void deleteHw() {
    }

    @Test
    void searchFirstname() {
    }

    @Test
    void searchLastName() {
    }

    @Test
    void searchLesson() {
    }
}