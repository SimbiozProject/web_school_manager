package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.*;
import com.example.web_school_manager.dao.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class AdminUserDataControllerTest {

    @Autowired
    AdminUserDataController adminUserDataController;

    @MockBean
    AdminService adminService;

    Long id = 1L;
    String userName = "user";
    String firstName = "firstUser";
    String lastName = "lastUser";
    String email = "mail@mail.ru";
    Date dateOfBirthday;
    Boolean active = true;
    Boolean blockUser = true;
    Boolean payment = true;
    Roles roles;
    Course courseUser;
    Group groupUser;

    private Optional<TgUser> makeExpOneUser() {
        return Optional.ofNullable(TgUser.builder().id(1L).userName("max").build());
    }

    private List<TgUser> makeExpUsers() {
        return List.of(
                TgUser.builder().id(1L).userName("max").build(),
                TgUser.builder().id(2L).userName("bax").build());
    }

    private TgUser makeExpTgUsers() {
        return TgUser.builder()
                .id(id)
                .userName(userName)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .dateOfBirthday(dateOfBirthday)
                .active(active)
                .blockUser(blockUser)
                .payment(payment)
                .roles(roles)
                .courseUser(courseUser)
                .groupUser(groupUser)
                .build();
    }

    @Test
    void deleteUserById() {
        when(adminService.findBlockUserById(id)).thenReturn(makeExpOneUser());
        ModelAndView viewResult = adminUserDataController.deleteUserById(id);
        assertThat(viewResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpDeleteUserView(id));
    }

    private ModelAndView getExpDeleteUserView(Long id) {
        ModelAndView modelAndView = new ModelAndView("/deleteUser.html");
        modelAndView.addObject("listUser", makeExpOneUser());
        return modelAndView;
    }

    @Test
    void deleteAndReturnToUserList() {
        doAnswer((i) -> {
            assertEquals(id, i.getArgument(0));
            return null;
        }).when(adminService).deleteUserById(id);
        ModelAndView viewResult = adminUserDataController.deleteAndReturnToUserList(id);
        assertThat(viewResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpDeleteView(id));
    }

    private ModelAndView getExpDeleteView(Long id) {
        ModelAndView modelAndView = new ModelAndView("/deleteUser.html");
        modelAndView.setViewName("redirect:/admin/statistic");
        return modelAndView;
    }

    @Test
    void updateDataUser() {
        when(adminService.findBlockUserById(id)).thenReturn(makeExpOneUser());
        ModelAndView viewResult = adminUserDataController.updateDataUser(id);
        assertThat(viewResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpUpdateView(id));
    }

    private ModelAndView getExpUpdateView(Long id) {
        ModelAndView modelAndView = new ModelAndView("/updateUserInfo.html");
        modelAndView.addObject("listUserForUpdate", makeExpOneUser());
        return modelAndView;
    }

    @Test
    void updateAllDataOfUsers() {
        doAnswer((i) -> {
            assertEquals(id, i.getArgument(0));
            assertEquals(userName, i.getArgument(1));
            assertEquals(firstName, i.getArgument(2));
            assertEquals(lastName, i.getArgument(3));
            assertEquals(email, i.getArgument(4));
            assertEquals(dateOfBirthday, i.getArgument(5));
            assertEquals(active, i.getArgument(6));
            assertEquals(blockUser, i.getArgument(7));
            assertEquals(payment, i.getArgument(8));
            assertEquals(roles, i.getArgument(9));
            assertEquals(courseUser, i.getArgument(10));
            assertEquals(groupUser, i.getArgument(11));
            return null;
        }).when(adminService).updateDataOfUser(id, userName, firstName, lastName, email, dateOfBirthday,
                active, blockUser, payment, roles, courseUser, groupUser);
        ModelAndView viewResult = adminUserDataController.updateAllDataOfUsers(id, userName, firstName, lastName, email, dateOfBirthday,
                active, blockUser, payment, roles, courseUser, groupUser);
        assertThat(viewResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpAllDataUpdateView());
    }

    private ModelAndView getExpAllDataUpdateView() {
        ModelAndView modelAndView = new ModelAndView("/updateUserInfo.html");
        modelAndView.setViewName("redirect:/admin/statistic");
        return modelAndView;
    }

    @Test
    void addUserToTable() {
        when(adminService.findAllUsers()).thenReturn(makeExpUsers());
        ModelAndView viewResult = adminUserDataController.addUserToTable();
        assertThat(viewResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpAddView());
    }

    private ModelAndView getExpAddView() {
        ModelAndView modelAndView = new ModelAndView("/addUser.html");
        return modelAndView;
    }

    @Test
    void addTgUserToTable() {
        doAnswer((i) -> {
            assertEquals(makeExpTgUsers(), i.getArgument(0));
            return null;
        }).when(adminService).addUserToDB(makeExpTgUsers());
        ModelAndView viewResult = adminUserDataController.addTgUserToTable(userName, firstName, lastName, email,
                dateOfBirthday, active, blockUser, payment, roles, courseUser, groupUser);
        assertThat(viewResult).usingRecursiveComparison()
                .ignoringAllOverriddenEquals()
                .isEqualTo(getExpAddTgUserView());
    }

    private ModelAndView getExpAddTgUserView() {
        ModelAndView modelAndView = new ModelAndView("/addUser.html");
        modelAndView.setViewName("redirect:/admin/statistic");
        return modelAndView;
    }
}