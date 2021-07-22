package com.example.web_school_manager.client;

import com.example.web_school_manager.bean.TgUser;

import java.util.*;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class UserClient {
    @Value("${client.processor}")
    private String uri;
    private final RestTemplate restTemplate;

    private String getAllUsers = "/users";
    private String getAllBlockUsers = "/blockUsers";
    private String getUserByName = "/findUserForBlock?userName="; // /findUserForBlock?userName=olga
    private String getUserById = "/deleteBlockUsers"+"/{id}";
    private String updateBlockStatus = "/updateBlockUser"+"/{id}";



    public List<TgUser> findAll() {
        ResponseEntity<TgUser[]> response =
                restTemplate.getForEntity(
                        String.format("%s%s", uri, getAllUsers),
                        TgUser[].class);
        TgUser[] users = response.getBody();
        return Arrays.asList(users);
    }

    public List<TgUser> findAllBlockUser() {
        ResponseEntity<TgUser[]> response =
                restTemplate.getForEntity(
                        String.format("%s%s", uri, getAllBlockUsers),
                        TgUser[].class);
        TgUser[] tgUsers = response.getBody();
        return Arrays.asList(tgUsers);
    }

    public Optional<TgUser> findByUserName(String userName) throws Exception {
            return Optional.of(restTemplate.getForObject(uri+getUserByName+"{userName}", TgUser.class, userName));
    }

    public Optional<TgUser> findTgUserTableById(Long id) {
        return Optional.of(restTemplate.getForObject(String.format("%s%s",uri, getUserById), TgUser.class, id));
//        return Optional.of(restTemplate.getForObject(uri+getUserById+"/{id}", TgUser.class, id));
    }

    public void deleteTgUserTableById(Long id) {
        restTemplate.delete(uri + getUserById, id);
    }

    public void updateBlockUserStatus(Long id, Boolean blockUser) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id.toString());
        params.put("blockUser", blockUser.toString());

        restTemplate.put(uri + updateBlockStatus, params);
    }



//    RestTemplate restTemplate = new RestTemplate();
//    String fooResourceUrl
//            = "http://localhost:8080/spring-rest/foos";
//    ResponseEntity<String> response
//            = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
//    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
//


//    Employee emp = new Employee(“E001”, "Eric Simmons");
//        Mockito
//                .when(restTemplate.getForEntity(
//                “http://localhost:8080/employee/E001”, Employee.class))
//            .thenReturn(new ResponseEntity(emp, HttpStatus.OK));
//
//    Employee employee = empService.getEmployee(id);
//        Assert.assertEquals(emp, employee);
}