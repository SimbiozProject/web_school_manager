package com.example.web_school_manager.controller;

import com.example.util.ExtendedModelResultMatchers;
import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.client.UserClient;
import com.example.web_school_manager.dao.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

import static com.example.util.BlockUserUtil.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BlockUserControllerIntTest {

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
    void blackListPageTest() throws Exception {
        when(restTemplate.getForEntity(
                "http://127.0.0.2:8080/blockUsers",
                TgUser[].class)).thenReturn(makeMockedBlockUsersResponseEntity());
        RequestBuilder request = MockMvcRequestBuilders.get("/admin/userBlock");

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                //todo replace with matcher
                .andExpect(new ExtendedModelResultMatchers().attribute("listBlockUser", makeExpectedBlockUsers()))
                .andReturn();
    }

    private TgUser[] makeMockedBlockUsers(){
        TgUser[] tgUsers = {
                TgUser.builder().id(1L).userName("olga").blockUser(true).build(),
                TgUser.builder().id(2L).userName("emily").blockUser(true).build()
        };
        return tgUsers;
    }
    private ResponseEntity<TgUser[]> makeMockedBlockUsersResponseEntity(){
        return  new ResponseEntity<TgUser[]>(makeMockedBlockUsers(), HttpStatus.OK);
    }


    @ParameterizedTest //не работает с незакомиченым html
    @CsvSource("olga")
//    @Test
    void searchUserForBlockTest(String userName) throws Exception {
//        String userName = "olga";
        when(restTemplate.getForObject("http://127.0.0.2:8080/findUserForBlock?userName="+"{userName}",
                TgUser.class, userName))
                .thenReturn(makeMockedSearchUserByName());
        RequestBuilder request = MockMvcRequestBuilders.get("/searchUserForBlock?userName="+"{userName}", userName);//"/findUserForBlock?userName=olga")

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                //todo replace with matcher
                .andExpect(new ExtendedModelResultMatchers().attribute("searchForBlockUser", makeExpectedSearchUserForBlock()))
                .andReturn();
    }
    public TgUser makeMockedSearchUserByName(){
        return TgUser.builder().id(1L).userName("olga").blockUser(true).build();
    }

    @ParameterizedTest //не работает с незакомиченым html
    @CsvSource("1")
    void deleteTgUserById(Long id) throws Exception {
        when(restTemplate.getForObject("http://127.0.0.2:8080/deleteBlockUsers"+"/{id}", TgUser.class, id))
                .thenReturn(makeMockedSearchUserById());
        RequestBuilder request = MockMvcRequestBuilders.get("/deleteBlockUsers/{id}", id);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(new ExtendedModelResultMatchers().attribute("blockUserDel", makeExpectedSearchUserForBlock()))
                .andReturn();
    }

    public static TgUser makeMockedSearchUserById(){
        return TgUser.builder().id(1L).userName("olga").blockUser(true).build();
    }

}

