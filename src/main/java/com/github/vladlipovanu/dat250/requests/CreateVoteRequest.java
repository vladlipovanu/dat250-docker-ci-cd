package com.github.vladlipovanu.dat250.requests;

import com.github.vladlipovanu.dat250.entities.Poll;
import com.github.vladlipovanu.dat250.entities.User;
import com.github.vladlipovanu.dat250.entities.Vote;

public class CreateVoteRequest {
    private User user;
    private Vote vote;
    private Poll poll;

    public CreateVoteRequest() { // does nothing atm
        }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }
}
