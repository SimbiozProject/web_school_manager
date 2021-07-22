package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.EnglishTest;
import com.example.web_school_manager.client.EnglishTestClient;
import com.example.web_school_manager.dao.service.EnglishTestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import static com.example.util.EnglishTestUtil.makeExpList;
import static com.example.util.EnglishTestUtil.makeMockedResponseEntityWithList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EnglishTestControllerIntTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    RestTemplate restTemplate;
    @SpyBean
    EnglishTestService englishTestService;
    @SpyBean
    EnglishTestClient englishTestClient;



    @Test
    void testPage() throws Exception {

        when(restTemplate.getForEntity(
                "http://127.0.0.2:8080/test",
                EnglishTest[].class)).thenReturn(makeMockedResponseEntityWithList());
        RequestBuilder request = MockMvcRequestBuilders.get("/test");
        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("testList", makeExpList()))
                .andReturn();

    }
}