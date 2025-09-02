package com.github.vladlipovanu.dat250.controllers;

import com.github.vladlipovanu.dat250.dto.*;
import com.github.vladlipovanu.dat250.requests.CreateVoteRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/vote")
public class VoteController {
    private final PollManager pollManager;

    public VoteController(final PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping
    public User voteRequest(@RequestBody CreateVoteRequest request) {
        User user = request.getUser();
        if (user.getVotes() == null) {
            user.setVotes(new ArrayList<>());
        }
        user.getVotes().add(request.getVote());
        pollManager.addPoll(request.getPoll(),user);
        return user;
    }

    @PutMapping
    public User updateVote(@RequestBody CreateVoteRequest request) {
        User requestUser = request.getUser();
        Vote newVote = request.getVote();

        User updatedUser = pollManager.updateUserVotes(requestUser.getUsername(), newVote);

        if (updatedUser == null) {
            if (requestUser.getVotes() == null) {
                requestUser.setVotes(new ArrayList<>());
            }
            requestUser.getVotes().clear();
            requestUser.getVotes().add(newVote);
            return requestUser;
        }

        return updatedUser;
    }

    @GetMapping()
    public List<Vote> getVotes() {
        List<Vote> allVotes = new ArrayList<>();

        for (User user : pollManager.getResults().values()) {
            if (user != null && user.getVotes() != null) {
                allVotes.addAll(user.getVotes());
            }
        }

        return allVotes;
    }
}
