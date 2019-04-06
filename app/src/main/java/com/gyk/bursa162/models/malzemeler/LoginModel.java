package com.gyk.bursa162.models.malzemeler;

public class LoginModel {
    private String userName;
    private String password;
    private String fullName;
    private String city;
    private String web;
    private String cv;

    public LoginModel(String userName, String password, String fullName, String city, String web, String cv) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.city = city;
        this.web = web;
        this.cv = cv;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }
}
