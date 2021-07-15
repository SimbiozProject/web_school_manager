package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.QuestionAnswerTable;
import com.example.web_school_manager.dao.service.QuestionAnswerTableDaoWebService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class QuestionAnswerTableControllerIntTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    QuestionAnswerTableDaoWebService questionAnswerTableDaoWebService;


    @SneakyThrows
    @Test
    void testPage() {
        RequestBuilder request = MockMvcRequestBuilders.get("/test")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(questionAnswerTableDaoWebService.findAll()));

        var expected = Arrays.asList(
                new QuestionAnswerTable(1L, "1", "f", "s", "th", "fo", "r"),
                new QuestionAnswerTable(2L, "2", "f2", "s2", "th2", "fo2", "r2")
        );

        MvcResult result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expected), false))
                .andReturn();
    }

    @Test
    void addTestPage() {
    }

    @Test
    void addTest() {
    }
}