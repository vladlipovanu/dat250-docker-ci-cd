package com.github.vladlipovanu.dat250.controllers;

import com.github.vladlipovanu.dat250.dto.CreatePollRequest;
import com.github.vladlipovanu.dat250.dto.Poll;
import com.github.vladlipovanu.dat250.dto.PollManager;
import org.springframework.web.bind.annotation.*;


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
        return pollManager.addPoll(request.getPoll(), request.getUser());
    }

    @GetMapping
    public Set<Poll> getPolls() {
       return pollManager.getPolls();
    }

}
