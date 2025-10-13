package com.github.vladlipovanu.dat250.dto;

public class VoteEvent {
    private Long voteOption;
    private Long userId;

    public VoteEvent(){}

    public VoteEvent(Long voteOption, Long userId) {
        this.voteOption = voteOption;
        this.userId = userId;
    }
    public Long getVoteOption() {
        return voteOption;
    }
    public void setVoteOption(Long voteOption) {
        this.voteOption = voteOption;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
