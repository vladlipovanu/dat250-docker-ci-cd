package com.github.vladlipovanu.dat250.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.*;

@Entity
@Table(name="users")
public class User implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    @OneToMany (mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Vote> votes;

    @OneToMany (mappedBy = "createdBy", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private Set<Poll> created;


    public User() { // does nothing atm
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.votes = new LinkedList<>();
        this.created = new LinkedHashSet<>();
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

    public Set<Poll> getCreated() {
        return created;
    }
    public void setCreated(Set<Poll> created) {
        this.created = created;
    }

    /**
     * Creates a new Poll object for this user
     * with the given poll question
     * and returns it.
     */
    public Poll createPoll(String question) {
        Poll newPoll = new Poll(question);
        newPoll.setCreator(this);
        this.created.add(newPoll);
        return newPoll;
    }

    /**
     * Creates a new Vote for a given VoteOption in a Poll
     * and returns the Vote as an object.
     */
    public Vote voteFor(VoteOption option) {
        Vote newVote = new Vote();
        newVote.setPublishedAt(Instant.now());
        newVote.setUser(this);
        newVote.setVotesOn(option);
        this.votes.add(newVote);
        return newVote;
    }

    public Long getId() {
        return id;
    }
}
