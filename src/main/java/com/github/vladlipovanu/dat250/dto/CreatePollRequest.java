package com.github.vladlipovanu.dat250.dto;


public class CreatePollRequest {
    private Poll poll;
    private User user;

    public CreatePollRequest() { // nothing atm
    }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Poll getPoll() { return poll; }
    public void setPoll(Poll poll) { this.poll = poll; }
}
