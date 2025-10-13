package com.github.vladlipovanu.dat250.entities;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.List;

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
    public Poll addVoteOptions(Poll poll, List<VoteOption> voteOptions) {
       poll.setOptions(voteOptions);
       return poll;
    }
    public HashMap<Poll, User> getResults() {
        return results;
    }
    public boolean removePoll(Poll poll) {
        return results.remove(poll) != null;
    }
    public void cleanupNullPolls() {
        results.keySet().removeIf(poll -> {
            if (poll == null) {
                return true;
            }
            return false;
        });
    }

    public User findUserByUsername(String username) {
        for (User user : results.values()) {
            if (user != null && user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User updateUserVotes(String username, Vote newVote) {
        User user = findUserByUsername(username);
        if (user != null) {
            if (user.getVotes() == null) {
                user.setVotes(new ArrayList<>());
            }
            user.getVotes().clear();
            user.getVotes().add(newVote);
        }
        return user;
    }

}
