package com.github.vladlipovanu.dat250.dto;

import java.time.Instant;

public class Vote  implements java.io.Serializable {
    private Instant publishedAt;
    private int voteOption;

    public Vote () { // does nothing atm
        }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public int getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(int voteOption) {
        this.voteOption = voteOption;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

}
