package com.example.web_school_manager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NewAdminControllerIntTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    NewAdminController newAdminController;

    @Test
    public void contextLoads() {
    }

    @Test
    void adminPageMenu() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/adminMenu");
        mockMvc.perform(request)
                .andDo(print())
        .andExpect(status().isOk());
    }

    @Test
    void testAdminPageMenu() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/schedule");
        this.mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("https://calendar.google.com/calendar/embed")));
    }

//    @Test
//    void testAdminPageMenu1() throws Exception {
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/userBlockList")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(newAdminController.blackListPage()));
//
//        var expected = "a JSON array";
//
//        MvcResult result = mockMvc.perform(requestBuilder)
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(expected), false))
//                .andReturn();
//    }

    /*
    @Test
    void addStudent() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/addStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new StudentDto("roo", "foo")));

        var expected = new StudentDto("max", "foo");

        MvcResult result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expected), false))
                .andReturn();
    }
     */
}