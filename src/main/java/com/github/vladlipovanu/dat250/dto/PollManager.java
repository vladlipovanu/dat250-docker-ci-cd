package com.github.vladlipovanu.dat250.dto;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Component
public class PollManager implements java.io.Serializable {
    private final HashMap<Poll,User> results = new HashMap<>();


    public PollManager() { // does nothing atm
    }

    public Poll addPoll (Poll poll, User user) {
        results.put(poll, user);
        return poll;
    }

    public Set<Poll> getPolls() {
        return results.keySet();
    }
    public User getUser (Poll poll) {
        return results.get(poll);
    }
}
