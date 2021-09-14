package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.EnglishTest;
import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.bean.UsersAnswer;
import com.example.web_school_manager.dao.service.UserAnswerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserAnswerControllerTest {

    @Autowired
    UserAnswerController userAnswerController;

    @MockBean
    UserAnswerService userAnswerService;

    @MockBean
    UsersAnswer usersAnswer;

    private List<UsersAnswer> usersAnswersList;
    private String userName;
    private Long id;

    @BeforeEach
    void setup() {
        usersAnswer = UsersAnswer.builder()
                .id(1L)
                .userName(TgUser.builder().userName("Vovc4eg").firstName("Vova").lastName("Sidorov").build())
                .questionAnswer(EnglishTest.builder().firstAnswer("where").build())
                .answer("firstAnswer")
                .build();
        usersAnswersList = List.of(
                UsersAnswer.builder()
                        .id(1L)
                        .userName(TgUser.builder().userName("Vovc4eg").firstName("Vova").lastName("Sidorov").build())
                        .questionAnswer(EnglishTest.builder().firstAnswer("where").build())
                        .answer("firstAnswer")
                        .build(),
                UsersAnswer.builder()
                        .id(2L)
                        .userName(TgUser.builder().userName("4eg").firstName("Vlad").lastName("Dorov").build())
                        .questionAnswer(EnglishTest.builder().firstAnswer("whene").build())
                        .answer("secondAnswer")
                        .build()

        );
        userName = usersAnswer.getUserName().getUserName();
        id = usersAnswer.getId();
    }

    @Test
    void getAllUserTest() {
        when(userAnswerService.findAll()).thenReturn(usersAnswersList);
        ModelAndView actual = userAnswerController.getAllUserTest();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedRorGetAllUserTest());
    }

    private ModelAndView getExpectedRorGetAllUserTest() {
        ModelAndView modelAndView = new ModelAndView("/allUsersTest");
        modelAndView.addObject("listUserAnswerTable", userAnswerService.findAll());
        return modelAndView;
    }

    @Test
    void searchByUserName() {
        when(userAnswerService.findByUserName(userName)).thenReturn(usersAnswer);
        ModelAndView actual = userAnswerController.searchByUserName(userName);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedForSearchByUserName(userName));
    }

    private ModelAndView getExpectedForSearchByUserName(String userName) {
        ModelAndView modelAndView = new ModelAndView("/allUsersTest");
        modelAndView.addObject("listUserAnswerTable", userAnswerService.findByUserName(userName));
        return modelAndView;
    }

    @Test
    void searchById() {
        when(userAnswerService.findById(id)).thenReturn(Optional.ofNullable(usersAnswer));
        ModelAndView actual = userAnswerController.searchById(id);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedForSearchById(id));
    }

    private ModelAndView getExpectedForSearchById(Long id) {
        ModelAndView modelAndView = new ModelAndView("/allUsersTest");
        modelAndView.addObject("listUserAnswerTable", userAnswerService.findById(id));
        return modelAndView;
    }

    @Test
    void getUserAnswerById() {
        when(userAnswerService.findById(id)).thenReturn(Optional.ofNullable(usersAnswer));
        ModelAndView actual = userAnswerController.getUserAnswerById(id);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedForGetUserAnswerById(id));
    }

    private ModelAndView getExpectedForGetUserAnswerById(Long id) {
        ModelAndView modelAndView = new ModelAndView("userTest");
        modelAndView.addObject("userAnswer", userAnswerService.findById(id));
        return modelAndView;
    }
}