package com.example.web_school_manager.controller;


import com.example.web_school_manager.dao.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.servlet.ModelAndView;

import static com.example.util.BlockUserUtil.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

@SpringBootTest
class BlockUserControllerTest {

    @Autowired
    BlockUserController blockUserController;

    @MockBean
    AdminService adminService;

    Long id = 1L;
    String userName = "olga";

    @Test
    void blackListPage() {
        when(adminService.findAllBlockUser()).thenReturn(makeExpectedBlockUsers());
        ModelAndView viewResult = blockUserController.blackListPage();
        assertThat(viewResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedViewBlackListPage());
    }

    @Test
    void searchUserForBlockByUserName() throws Exception {
        when(adminService.searchTgUserForBlockList(userName)).thenReturn(makeExpectedSearchUserForBlock());
        ModelAndView viewResult = blockUserController.searchUserForBlock(userName);
        assertThat(viewResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedViewSearchUserForBlock());

    }

    @Test
    void findTgUserById() {
        when(adminService.findBlockUserById(id)).thenReturn(makeExpectedSearchUserForBlock());
        ModelAndView viewResult = blockUserController.deleteTgUserById(id);
        assertThat(viewResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedViewFindTgUserById());
    }

    @Test
    void deleteAndReturnToBlackList() {
        doAnswer((i) -> {
            assertEquals(id, i.getArgument(0));
            return null;
    }).when(adminService).deleteUserById(id);
        ModelAndView viewResult = blockUserController.deleteAndReturnToBlackList(id);
        assertThat(viewResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedViewDeleteAndReturn(id));
    }

    @Test
    void updateStatusBlockUser() {
        doAnswer((i) -> {
                assertEquals(id, i.getArgument(0));
                assertEquals(true, i.getArgument(1));
            return null;
        }).when(adminService).updateBlockStatusUser(id, true);
        ModelAndView viewResult = blockUserController.updateStatusBlockUser(id, true);
        assertThat(viewResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpectedViewUpdateStatusBlockUser(id, true));
    }

}