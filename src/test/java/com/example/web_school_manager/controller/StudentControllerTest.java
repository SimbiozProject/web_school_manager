package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void loadStudent() throws Exception {
        // if equals on string
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/loadStudent", new Student("foo", "good"));
//        MvcResult result = mockMvc.perform(requestBuilder)
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn();
//        String content = result.getResponse().getContentAsString();
//        assertEquals("{\"name\":\"vova\",\"lastName\":\"petra\"}", content);

        // if with @RequestBody as Json.file
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/loadStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new Student("foo", "good")));

        var expected = new Student("vova", "petra");

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expected)))
                .andReturn();
    }

    @Test
    void getStudent() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getStudent");
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk());
    }
}