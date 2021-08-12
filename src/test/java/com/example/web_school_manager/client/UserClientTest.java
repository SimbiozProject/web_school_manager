package com.example.web_school_manager.client;

import static com.example.util.BlockUserUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

import com.example.web_school_manager.bean.TgUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class UserClientTest {

    @Autowired
    UserClient userClient;
    @MockBean
    RestTemplate restTemplate;

    @Test
    void findAll() {
        when(restTemplate.getForEntity(
                "http://127.0.0.2:8080/users",
                TgUser[].class)).thenReturn(makeMockedResponseEntity());
        List<TgUser> actual = userClient.findAll();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpectedUsers());
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

    @Test
    void findAllBlockUser() {
            when(restTemplate.getForEntity(
                    "http://127.0.0.2:8080/blockUsers",
                    TgUser[].class)).thenReturn(makeMockedBlockUsersResponseEntity());
            List<TgUser> actual = userClient.findAllBlockUser();
            assertThat(actual).usingRecursiveComparison()
                    .ignoringAllOverriddenEquals()
                    .isEqualTo(makeExpectedBlockUsers());
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

    @Test
    void findByUserName() throws Exception {
        String userName = "olga";
        when(restTemplate.getForObject("http://127.0.0.2:8080/findUserForBlock?userName="+"{userName}",
                TgUser.class, userName))
                .thenReturn(makeMockedSearchUserByName());
        Optional<TgUser> actual = userClient.findByUserName(userName);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpectedSearchUserForBlock());
    }

    public static TgUser makeMockedSearchUserByName(){
        return TgUser.builder().id(1L).userName("olga").blockUser(true).build();
    }

    @Test
    void findTgUserTableById() {
        Long id = 1L;
        when(restTemplate.getForObject("http://127.0.0.2:8080/deleteBlockUsers"+"/{id}", TgUser.class, id))
                .thenReturn(makeMockedSearchUserById());
        Optional<TgUser> actual = userClient.findTgUserTableById(id);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpectedSearchUserForBlock());
    }

    public static TgUser makeMockedSearchUserById(){
        return TgUser.builder().id(1L).userName("olga").blockUser(true).build();
    }

    @Test
    void deleteTgUserTableById() {
        Long id = makeExpectedSearchUserForBlock().get().getId();
        userClient.deleteTgUserTableById(id);
        verify(restTemplate, times(1)).delete("http://127.0.0.2:8080/deleteBlockUsers"+"/{id}", id);
    }

    @Test
    void updateBlockUserStatus() {
        Long id = makeExpectedUpdateStatusBlockUser().getId();
        Boolean blockUser = false;
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id.toString());
        params.put("blockUser", blockUser.toString());
        userClient.updateBlockUserStatus(id,blockUser);
        verify(restTemplate, times(1)).put("http://127.0.0.2:8080/updateBlockUser"+"/{id}", params);
    }
}