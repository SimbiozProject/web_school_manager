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
public class CrmUserTable  implements Serializable {

    private Long userId;

    private TgUserTable tgUserTable;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String dateOfBirth;

    private String countryName;

    private String cityName;

    private String eMail;
}
