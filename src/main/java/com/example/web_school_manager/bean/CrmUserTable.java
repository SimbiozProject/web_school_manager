package com.example.web_school_manager.bean;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
@Table(name = "crm_registration")
public class CrmUserTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @JoinColumn(name = "user_name", nullable = false)
    private TgUserTable tgUserTable;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "e_mail")
    private String eMail;

    public CrmUserTable() {
    }

    public CrmUserTable(Long userId, TgUserTable tgUserTable, String firstName, String lastName, String phoneNumber, String dateOfBirth, String countryName, String cityName, String eMail) {
        this.userId = userId;
        this.tgUserTable = tgUserTable;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.countryName = countryName;
        this.cityName = cityName;
        this.eMail = eMail;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public TgUserTable getTgUserTable() {
        return tgUserTable;
    }

    public void setTgUserTable(TgUserTable tgUserTable) {
        this.tgUserTable = tgUserTable;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
