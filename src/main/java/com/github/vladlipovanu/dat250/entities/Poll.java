package com.github.vladlipovanu.dat250.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Poll implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String question;
    private Instant publishedAt;
    private Instant validUntil;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VoteOption> options;

    @ManyToOne(fetch = FetchType.LAZY)
    private User createdBy;



    public Poll () { // does nothing atm
    }

    public Poll (String question) {
        this.question = question;
        this.options = new ArrayList<>();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Instant validUntil) {
        this.validUntil = validUntil;
    }

    public List<VoteOption> getOptions() {
        return options;
    }

    public void setOptions(List<VoteOption> voteOptions) {
        this.options = voteOptions;
    }

    public User getCreator () {
        return createdBy;
    }
    public void setCreator (User user) {
        this.createdBy = user;
    }


    /**
     *
     * Adds a new option to this Poll and returns the respective
     * VoteOption object with the given caption.
     * The value of the presentationOrder field gets determined
     * by the size of the currently existing VoteOptions for this Poll.
     * I.e. the first added VoteOption has presentationOrder=0, the secondly
     * registered VoteOption has presentationOrder=1 and so on.
     */
    public VoteOption addVoteOption(String caption) {
        int index = options.size();
        VoteOption voteOption = new VoteOption(caption,index);
        voteOption.setPoll(this);
        options.add(index,voteOption);
        return voteOption;
    }
}
