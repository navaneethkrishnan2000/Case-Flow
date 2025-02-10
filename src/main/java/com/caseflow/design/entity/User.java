package com.caseflow.design.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = true, length = 100)
    private String lastName;

    @Column(name = "emp_id", length = 20, unique = true)
    private String empId;

    @Column(name = "profile_img")
    @Lob
    private byte[] profileImg;

    @Column(name = "gender", length = 100, nullable = false)
    private String gender;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "zipcode", nullable = false, length = 100)
    private String zipcode;

    @Column(name = "phone_number", nullable = false , length = 50)
    private String phoneNumber;

    @Column(name = "address", nullable = true , length = 300)
    private String address;

    @Column(name = "language", nullable = false , length = 300)
    private String language;

    @Column(name = "personal_email", nullable = true , length = 100)
    private String personalEmail;

    @Column(name = "personal_phone", nullable = true , length = 50)
    private String personalPhone;

    @Column(name = "designation", nullable = false, length = 100)
    private String designation;

    @JsonIgnore
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserAuth userAuth;

    // Constructor
    public User(Long userId, String firstName, String lastName, String empId, byte[] profileImg, String gender, String region, String state, String district, String zipcode, String phone, String address, String language, String personalEmail, String personalPhone, String designation, UserAuth userAuth) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.empId = empId;
        this.profileImg = profileImg;
        this.gender = gender;
        this.region = region;
        this.state = state;
        this.district = district;
        this.zipcode = zipcode;
        this.phoneNumber = phone;
        this.address = address;
        this.language = language;
        this.personalEmail = personalEmail;
        this.personalPhone = personalPhone;
        this.designation = designation;
        this.userAuth = userAuth;
    }

    public User() {
    }

    // Getters and Setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public byte[] getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(byte[] profileImg) {
        this.profileImg = profileImg;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public UserAuth getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(UserAuth userAuth) {
        this.userAuth = userAuth;
    }
}
