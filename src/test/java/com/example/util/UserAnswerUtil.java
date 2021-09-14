package com.example.util;

import com.example.web_school_manager.bean.EnglishTest;
import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.bean.UsersAnswer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserAnswerUtil {

    public static ResponseEntity<UsersAnswer[]> makeMockedResponseEntityWithListUsersAnswer() {
        return new ResponseEntity<>(makeMockedArrayUsersAnswer(), HttpStatus.OK);
    }

    public static ResponseEntity<UsersAnswer> makeMockedResponseEntityWithUsersAnswer() {
        return new ResponseEntity<>(makeExampleUserAnswer(), HttpStatus.OK);
    }

    public static UsersAnswer makeExampleUserAnswer() {
        return UsersAnswer.builder()
                .id(1L)
                .userName(TgUser.builder().userName("Vova").lastName("Petranovski").build())
                .questionAnswer(EnglishTest.builder().firstAnswer("1").build())
                .answer("first")
                .build();
    }

    public static List<UsersAnswer> makeExampleListUsersAnswer() {
        return List.of(
                UsersAnswer.builder()
                        .id(1L)
                        .userName(TgUser.builder().userName("Vova").lastName("Petranovski").build())
                        .questionAnswer(EnglishTest.builder().firstAnswer("1").build())
                        .answer("first")
                        .build(),
                UsersAnswer.builder()
                        .id(2L)
                        .userName(TgUser.builder().userName("Vlad").lastName("Buriak").build())
                        .questionAnswer(EnglishTest.builder().firstAnswer("2").build())
                        .answer("second")
                        .build()
        );
    }

    private static UsersAnswer[] makeMockedArrayUsersAnswer() {
        UsersAnswer[] array = {
                UsersAnswer.builder()
                        .id(1L)
                        .userName(TgUser.builder().userName("Vova").lastName("Petranovski").build())
                        .questionAnswer(EnglishTest.builder().firstAnswer("1").build())
                        .answer("first")
                        .build(),
                UsersAnswer.builder()
                        .id(2L)
                        .userName(TgUser.builder().userName("Vlad").lastName("Buriak").build())
                        .questionAnswer(EnglishTest.builder().firstAnswer("2").build())
                        .answer("second")
                        .build()
        };
        return array;
    }
}
