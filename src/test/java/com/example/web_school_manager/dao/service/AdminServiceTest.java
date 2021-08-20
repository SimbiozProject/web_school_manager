package com.example.web_school_manager.dao.service;

import static com.example.util.BlockUserUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.OPTIONAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.client.UserClient;

import java.util.List;
import java.util.Optional;

import com.example.web_school_manager.dao.repository.TgUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.servlet.ModelAndView;

@SpringBootTest(webEnvironment = RANDOM_PORT, properties = {"spring.cloud.config.enabled=false"})
class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @MockBean
    UserClient userClient;

    @MockBean
    TgUserRepository tgUserRepository;

    @Test
    void findAllUsers() {
        when(userClient.findAll()).thenReturn(makeExpectedUsers());
        List<TgUser> actual = adminService.findAllUsers();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpectedUsers());
    }

    private List<TgUser> makeExpectedUsers() {
        return List.of(
                TgUser.builder().id(1L).userName("max").build(),
                TgUser.builder().id(2L).userName("bax").build());
    }

    @Test
    void findAllBlockUser() {
        when(userClient.findAllBlockUser()).thenReturn(makeExpectedBlockUsers());
        List<TgUser> actual = adminService.findAllBlockUser();
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpectedBlockUsers());
    }

    @Test
    void searchTgUserForBlockList() throws Exception {
        String userName = "olga";
        when(userClient.findByUserName(makeExpectedSearchUserForBlock().get().getUserName()))
                .thenReturn(makeExpectedSearchUserForBlock());
        Optional<TgUser> actual = adminService.searchTgUserForBlockList(userName);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpectedSearchUserForBlock());
    }

    @Test
    void findBlockUserById() {
        Long id = 1L;
        when(userClient.findTgUserTableById(makeExpectedSearchUserForBlock().get().getId()))
                .thenReturn(makeExpectedSearchUserForBlock());
        Optional<TgUser> actual = adminService.findBlockUserById(id);
        assertThat(actual).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(makeExpectedSearchUserForBlock());
    }


    @Test
    void deleteUserById() {
        Long id = 1L;
        doNothing().when(userClient).deleteTgUserTableById(id);
        adminService.deleteUserById(id);
        verify(userClient, times(1)).deleteTgUserTableById(id);
    }


    @Test
    void updateBlockStatusUser() {
        Long id = makeExpectedUpdateStatusBlockUser().getId();
        Boolean blockUser = false;

        doNothing().when(userClient).updateBlockUserStatus(id, blockUser);
        adminService.updateBlockStatusUser(id,blockUser);
        verify(userClient, times(1)).updateBlockUserStatus(id, blockUser);
    }
}
