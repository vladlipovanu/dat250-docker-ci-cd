package com.github.vladlipovanu.dat250.dto;

import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Entity
public class VoteOption implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String caption;
    private int presentationOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    private Poll poll;

    @OneToMany(mappedBy = "votesOn", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final List<Vote> votes = new ArrayList<>();

    public VoteOption() { // does nothing atm
    }

    public VoteOption(String caption, int presentationOrder) {
        this.caption = caption;
        this.presentationOrder = presentationOrder;
    }
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getPresentationOrder() {
        return presentationOrder;
    }

    public void setPresentationOrder(int presentationOrder) {
        this.presentationOrder = presentationOrder;
    }
    public void setPoll(Poll poll) {
        this.poll = poll;
    }
}
