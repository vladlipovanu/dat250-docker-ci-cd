package com.github.vladlipovanu.dat250.dto;

public class User implements java.io.Serializable {
    private String username;
    private String email;


    public User() { // does nothing atm
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}