package com.github.vladlipovanu.dat250.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Vote  implements java.io.Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private Instant publishedAt;
    private int voteOption;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private VoteOption votesOn;

    public Vote () { // does nothing atm
    }
    public Vote (Instant publishedAt, int voteOption) {
        this.publishedAt = publishedAt;
        this.voteOption = voteOption;
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

    public void setUser(User user) {
        this.user = user;
    }
    public void setVotesOn(VoteOption votesOn) {
        this.votesOn = votesOn;
    }

    public Long getId() {
        return id;
    }

}
