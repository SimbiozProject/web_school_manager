package com.example.web_school_manager.dao.service;

import com.example.web_school_manager.bean.Course;
import com.example.web_school_manager.bean.Group;
import com.example.web_school_manager.bean.TgUser;
import com.example.web_school_manager.bean.Roles;
import com.example.web_school_manager.client.UserClient;
import com.example.web_school_manager.dao.repository.TgUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final TgUserRepository tgUserRepository;
    private final UserClient userClient;

    public List<TgUser> findAllBlockUser(){
        return userClient.findAllBlockUser();
    }

    public void deleteUserById(Long id){
        userClient.deleteTgUserTableById(id);
    }

    public Optional<TgUser> findBlockUserById(Long id){
        return userClient.findTgUserTableById(id);
    }

    public void updateBlockStatusUser(Long id, Boolean blockUser){
        userClient.updateBlockUserStatus(id, blockUser);
    }

    public Optional<TgUser> searchTgUserForBlockList(String userName) throws Exception {
        return userClient.findByUserName(userName);
    }

    public List<TgUser> findAllUsers(){
        return userClient.findAll();
    }

    public void updateDataOfUser(Long id, String userName, String firstName, String lastName, String email,
                                 Date dateOfBirthday, Boolean active, Boolean blockUser, Boolean payment, Roles roles,
                                 Course courseUser, Group groupUser){
        tgUserRepository.updateUsersData(id, userName, firstName, lastName, email, dateOfBirthday,
                active, blockUser, payment, roles, courseUser, groupUser);
    }

    public void addUserToDB(TgUser newTgUser){
        tgUserRepository.save(newTgUser);
    }
}
