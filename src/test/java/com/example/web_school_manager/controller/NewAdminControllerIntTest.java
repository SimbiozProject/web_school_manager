package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.dao.repository.TgUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class NewAdminControllerIntTest {
//    @Autowired
//    TgUserRepository tgUserRepository;
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper objectMapper;
//
////    @MockBean
////    private NewAdminController newAdminController;
//
//    @Autowired
//    NewAdminController newAdminController;
//
//    @Test
//    public void contextLoads() {
//    }
//
//    @Test
//    void adminPageMenuTest() throws Exception {
//        RequestBuilder request = MockMvcRequestBuilders.get("/adminMenu");
//        mockMvc.perform(request)
//                .andDo(print())
//        .andExpect(status().isOk());
//    }
//
//    @Test
//    void schedulePageTest() throws Exception {
//        RequestBuilder request = MockMvcRequestBuilders.get("/schedule");
//        this.mockMvc.perform(request)
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content()
//                        .string(containsString("https://calendar.google.com/calendar/embed")));
//    }
//
//    @Test
//    void blackListPageTest() throws Exception {
//    RequestBuilder request = MockMvcRequestBuilders.get("/userBlock")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(objectMapper.writeValueAsString(newAdminController.blackListPage()));
//
//    var expected = newAdminController.blackListPage();
//
//    MvcResult result = mockMvc.perform(request)
//            .andDo(print())
//            .andExpect(status().isOk())
//            .andExpect(content().json(objectMapper.writeValueAsString(expected), false))
//            .andReturn();
//}
//
//    @ParameterizedTest
//    @CsvSource("olga")
//    void searchUserForBlockTest(String userName) throws Exception {
//        RequestBuilder request = MockMvcRequestBuilders.get("/findUserForBlock?userName=olga")//"/findUserForBlock?userName=olga")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(newAdminController.searchUserForBlock(userName)));
//
//        var expected = newAdminController.searchUserForBlock(userName);
//
//        MvcResult result = mockMvc.perform(request)
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(expected), false))
//                .andReturn();
//    }
//
//    @ParameterizedTest
//    @CsvSource("1")
//    void deleteTgUserById(Long id) throws Exception {
//        RequestBuilder request = MockMvcRequestBuilders.get("/blockUserDelete/{id}", id)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(newAdminController.deleteTgUserById(id)));
//
//        var expected = newAdminController.deleteTgUserById(id);
//
//        MvcResult result = mockMvc.perform(request)
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(expected), false))
//                .andReturn();
//    }
//
//
//    @ParameterizedTest  //копия теста deleteTgUserById() выше который, просто подругому переписанный
//    @CsvSource("1")
//    void deleteTgUserById1(Long id) throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/blockUserDelete/{id}", id))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(id))
//                .andExpect(jsonPath("$.userName").value("emily"));
//
//    }
//
//    @ParameterizedTest
//    @CsvSource("5")
//    void deleteAndReturnToBlackList(Long id) throws Exception {
//        RequestBuilder request = MockMvcRequestBuilders.delete("/blockUserDelete/{id}", id)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(newAdminController.deleteAndReturnToBlackList(id)));
//
//        MvcResult result = mockMvc.perform(request)
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn();
//    }
//
//    @ParameterizedTest
//    @CsvSource("1")
//    void updateStatusBlock(Long id) throws Exception {
//        RequestBuilder request = MockMvcRequestBuilders.get("/blockUserUpdate/{id}", id)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(newAdminController.updateStatusBlock(id)));
//
//        var expected = newAdminController.updateStatusBlock(id);
//
//        MvcResult result = mockMvc.perform(request)
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(expected), false))
//                .andReturn();
//    }
//
////    static Stream<Arguments> arguments = Stream.of(Arguments.of("1", true));
//
//
//@ParameterizedTest
//@CsvSource("6")
//    void updateStatusBlockUser(Long id) throws Exception {
//
//    mockMvc.perform(MockMvcRequestBuilders.post("/blockUserUpdate/{id}", id)
//            .contentType(MediaType.APPLICATION_JSON)
//            .param("blockUser", "false")
//            .content(objectMapper.writeValueAsString(newAdminController.updateStatusBlockUser(id, false))))
//            .andDo(print())
//            .andExpect(status().isOk())
//            .andReturn();
//
//    Optional<TgUser> tgUserTable = tgUserRepository.findById(6L);
//    assertThat(tgUserTable.get().getBlockUser()).isEqualTo(false);
//}
//
//
////    MvcResult result = mockMvc.perform(requestBuilder)
////            .andDo(print())
////            .andExpect(status().isOk())
//////            .andExpect(content().json(objectMapper.writeValueAsString(expected), false))
////            .andReturn();
//
//
////        MvcResult result = mockMvc.perform(requestBuilder)
////                .andDo(print())
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.id").value("6"))
//////                .andExpect(jsonPath("$.blockUser").value(false))
////                .andReturn();
//
//
//
//
//
////    @Test
////    void updateStatusBlockUser1(Long id) throws Exception {
////        RequestBuilder request = MockMvcRequestBuilders.post("/blockUserUpdate/{id}", id)
////                .contentType(MediaType.APPLICATION_JSON)
////                .content(objectMapper.writeValueAsString(new TgUserTable(id, true)));
////
////        var expected = newAdminController.updateStatusBlockUserUser(id, false);
////
////        MvcResult result = mockMvc.perform(request)
////                .andDo(print())
////                .andExpect(status().isOk())
////                .andExpect(content().json(objectMapper.writeValueAsString(expected), false))
////                .andReturn();
////
////    }
//
//
///*
//
//   long id = createTestPerson("Nick").getId();
//    mockMvc.perform(
//            put("/persons/{id}", id)
//                    .content(objectMapper.writeValueAsString(new Person("Michail")))
//                    .contentType(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk())
//            .andExpect(jsonPath("$.id").value("1"))
//            .andExpect(jsonPath("$.name").value("Michail"));
//}
//
//
//
// mockMvc.perform(
//            delete("/persons/{id}", person.getId()))
//                    .andExpect(status().isOk())
//                    .andExpect(content().json(objectMapper.writeValueAsString(person)));
//}
//
// mockMvc.perform(
//            get("/persons/{id}", id))
//            .andExpect(status().isOk())
//            .andExpect(jsonPath("$.id").value(id))
//            .andExpect(jsonPath("$.name").value("Michail"));
// */
//
//
////    @Test
////    void testAdminPageMenu1() throws Exception {
////        RequestBuilder request = MockMvcRequestBuilders.get("/userBlockList");
////        when(newAdminController.blackListPage()).thenReturn(Arrays.asList(
////                new TgUserTable(1L, "Vasya", true),
////                new TgUserTable(2L, "Masya", true)
////        ));
////
////        mockMvc.perform(request)
////                .andDo(print())
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$", hasSize(2)))
////                .andExpect(jsonPath("$.id", containsInAnyOrder(1,2)))
////                .andReturn();
////    }
//
//    /*
//    @Test
//    void addStudent() throws Exception {
//        RequestBuilder request = MockMvcRequestBuilders.post("/addStudent")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(new StudentDto("roo", "foo")));
//
//        var expected = new StudentDto("max", "foo");
//
//        MvcResult result = mockMvc.perform(request)
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(expected), false))
//                .andReturn();
//    }
//     */

}