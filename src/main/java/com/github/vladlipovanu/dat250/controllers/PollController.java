package com.github.vladlipovanu.dat250.controllers;

import com.github.vladlipovanu.dat250.dto.*;
import com.github.vladlipovanu.dat250.requests.CreatePollRequest;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Set;

@RestController
@RequestMapping("/polls")
public class PollController {
    private final PollManager pollManager;

    public PollController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping
    public Poll addPoll(@RequestBody CreatePollRequest request) {

        if (request.getPoll() == null) {
            return null;
        }

        Poll newPoll = pollManager.addPoll(request.getPoll(), request.getUser());
        if (newPoll != null && request.getVoteOptions() != null) {
            return pollManager.addVoteOptions(newPoll, request.getVoteOptions());
        }
        return newPoll;
    }

    @GetMapping
    public Set<Poll> getPolls() {
       return pollManager.getPolls();
    }

    @DeleteMapping
    public boolean deletePoll(@RequestParam String question) {
        pollManager.cleanupNullPolls();

        Poll pollToRemove = pollManager.getResults().keySet().stream()
                .filter(poll -> poll != null && poll.getQuestion() != null && poll.getQuestion().equals(question))
                .findFirst()
                .orElse(null);

        if (pollToRemove != null) {
            for (User user : pollManager.getResults().values()) {
                if (user != null) {
                    user.setVotes(new ArrayList<>());
                }
            }

            return pollManager.removePoll(pollToRemove);
        }
        return false;
    }


}
