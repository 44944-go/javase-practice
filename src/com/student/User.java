package com.student;

public class User {
    private String userName;
    private String passWor;
    private String personId;
    private String phoneNumber;

    public User(String userName, String passWor, String personId, String phoneNumber) {
        this.userName = userName;
        this.passWor = passWor;
        this.personId = personId;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWor() {
        return passWor;
    }

    public void setPassWor(String passWor) {
        this.passWor = passWor;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
