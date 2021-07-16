package com.example.web_school_manager.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Crm implements Serializable {

    private Long userId;

    private TgUser tgUser;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String dateOfBirth;

    private String countryName;

    private String cityName;

    private String eMail;
}
