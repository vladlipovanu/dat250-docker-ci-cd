package com.github.vladlipovanu.dat250.dto;

import java.util.List;

public class User implements java.io.Serializable {
    private String username;
    private String email;
    private List<Vote> votes;


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

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}