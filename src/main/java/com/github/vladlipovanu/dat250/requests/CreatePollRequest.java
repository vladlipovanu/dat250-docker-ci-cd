package com.github.vladlipovanu.dat250.requests;


import com.github.vladlipovanu.dat250.dto.Poll;
import com.github.vladlipovanu.dat250.dto.User;
import com.github.vladlipovanu.dat250.dto.VoteOption;

import java.util.List;

public class CreatePollRequest {
    private Poll poll;
    private User user;
    private List<VoteOption> voteOptions;

    public CreatePollRequest() { // nothing atm
    }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Poll getPoll() { return poll; }
    public void setPoll(Poll poll) { this.poll = poll; }
    public List<VoteOption> getVoteOptions() { return voteOptions; }
    public void setVoteOptions(List<VoteOption> voteOptions) { this.voteOptions = voteOptions; }

}
