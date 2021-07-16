package com.example.web_school_manager.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.util.ExtendedModelResultMatchers;
import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.client.UserClient;
import com.example.web_school_manager.dao.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@AutoConfigureMockMvc
class StatisticControllerIntTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    RestTemplate restTemplate;
    @SpyBean
    AdminService adminService;
    @SpyBean
    UserClient userClient;

    @Test
    void findAllUsers() throws Exception {
        when(restTemplate.getForEntity(
                "http://127.0.0.2:8080/users",
                TgUser[].class)).thenReturn(makeMockedResponseEntity());
        RequestBuilder request = MockMvcRequestBuilders.get("/admin/statistic");
        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                // todo: replace with matcher
                .andExpect(new ExtendedModelResultMatchers().attribute("statisticList", makeExpectedUsers()))
                .andReturn();
    }

    private List<TgUser> makeExpectedUsers() {
        return List.of(
                TgUser.builder().id(1L).userName("max").build(),
                TgUser.builder().id(2L).userName("bax").build());
    }

    private TgUser[] makeMockedUsers() {
        TgUser[] tgUsers = {
                TgUser.builder().id(1L).userName("max").build(),
                TgUser.builder().id(2L).userName("bax").build()
        };
        return tgUsers;
    }

    private ResponseEntity<TgUser[]> makeMockedResponseEntity() {
        return new ResponseEntity<TgUser[]>(makeMockedUsers(), HttpStatus.OK);
    }
}