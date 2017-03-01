package com.nixsolutions.dto;

import com.nixsolutions.bean.*;

import java.sql.Date;

public class UserDTO {

    private Long userID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Integer karma;
    private String userRole;
    private Long addressID;
    private String houseNumber;
    private String flatNumber;
    private String cityName;
    private String streetName;
    private Integer documentID;
    private String documentType;
    private String series;
    private Integer number;
    private String issuedBy;
    private Date dateOfIssue;

    public static UserDTO getUserDTO(User user) {
        UserDTO userDTO = new UserDTO(user.getUserID(), user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getPassword(), user.getPhoneNumber(), user.getKarma(), user.getRole().getUserRole(),
                user.getAddress().getAddressID(), user.getAddress().getHouseNumber(), user.getAddress().getFlatNumber(),
                user.getAddress().getCityName(), user.getAddress().getStreetName(), user.getDocument().getDocumentID(),
                user.getDocument().getDocumentType().getDocumentType(), user.getDocument().getSeries(),
                user.getDocument().getNumber(), user.getDocument().getIssuedBy(), user.getDocument().getDateOfIssue());
        return userDTO;
    }

    public static User getUser(UserDTO userDTO) {
        User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(), userDTO.getPassword(),
                userDTO.getPhoneNumber(), userDTO.getKarma(), new Role(userDTO.getUserRole()),
                new Address(userDTO.getAddressID(), userDTO.getHouseNumber(), userDTO.getFlatNumber(), userDTO.getCityName(),
                        userDTO.getStreetName()), new Document(userDTO.getDocumentID(), new DocumentType(userDTO.getDocumentType()),
                userDTO.getSeries(), userDTO.getNumber(), userDTO.getIssuedBy(), userDTO.getDateOfIssue()));
        user.setUserID(userDTO.getUserID());
        return user;
    }

    public UserDTO(Long userID, String firstName, String lastName, String email, String password, String phoneNumber,
                   Integer karma, String userRole, Long addressID, String houseNumber, String flatNumber,
                   String cityName, String streetName, Integer documentID, String documentType, String series,
                   Integer number, String issuedBy, Date dateOfIssue) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.karma = karma;
        this.userRole = userRole;
        this.addressID = addressID;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.cityName = cityName;
        this.streetName = streetName;
        this.documentID = documentID;
        this.documentType = documentType;
        this.series = series;
        this.number = number;
        this.issuedBy = issuedBy;
        this.dateOfIssue = dateOfIssue;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getKarma() {
        return karma;
    }

    public void setKarma(Integer karma) {
        this.karma = karma;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Long getAddressID() {
        return addressID;
    }

    public void setAddressID(Long addressID) {
        this.addressID = addressID;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getDocumentID() {
        return documentID;
    }

    public void setDocumentID(Integer documentID) {
        this.documentID = documentID;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public UserDTO() {
    }
}
