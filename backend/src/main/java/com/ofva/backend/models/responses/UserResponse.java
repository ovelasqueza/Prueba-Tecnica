package com.ofva.backend.models.responses;

public class UserResponse {
    private String firstName;
    private String lastName;
    private String secondName;
    private String secondLastName;
    private String phoneNumber;
    private String address;
    private String city;

    public UserResponse(String firstName,String secondName, String lastName, String secondLastName, String phoneNumber, String address, String city) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
