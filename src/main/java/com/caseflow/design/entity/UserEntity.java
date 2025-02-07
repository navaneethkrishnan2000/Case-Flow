package com.caseflow.design.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = true, length = 100)
    private String lastName;

    @Column(length = 20, unique = true)
    private String empId;

    @Lob
    private byte[] profile;

    @Column(length = 100, nullable = false)
    private String gender;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false, length = 100)
    private String zipcode;

    @Column(nullable = false , length = 50)
    private String phone;

    @Column(nullable = true , length = 300)
    private String address;

    @Column(nullable = false , length = 300)
    private String language;

    @Column(nullable = true , length = 100)
    private String personalEmail;

    @Column(nullable = true , length = 50)
    private String personalPhone;

    @Column(nullable = false, length = 100)
    private String designation;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    private UserAuthEntity userAuth;

    public UserAuthEntity getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(UserAuthEntity userAuth) {
        this.userAuth = userAuth;
    }

    public UserEntity() {

    }

    public UserEntity(String address, String district, String empId, String firstName, String gender, String language, String lastName, String personalEmail, String personalPhone, String phone, byte[] profile, String region, String state, String zipcode, String designation) {
        this.address = address;
        this.district = district;
        this.empId = empId;
        this.firstName = firstName;
        this.gender = gender;
        this.language = language;
        this.lastName = lastName;
        this.personalEmail = personalEmail;
        this.personalPhone = personalPhone;
        this.phone = phone;
        this.profile = profile;
        this.region = region;
        this.state = state;
        this.zipcode = zipcode;
        this.designation = designation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getPersonalPhone() {
        return personalPhone;
    }

    public void setPersonalPhone(String personalPhone) {
        this.personalPhone = personalPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getProfile() {
        return profile;
    }

    public void setProfile(byte[] profile) {
        this.profile = profile;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}
