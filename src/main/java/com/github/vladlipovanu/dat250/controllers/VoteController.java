package com.github.vladlipovanu.dat250.controllers;

import com.github.vladlipovanu.dat250.entities.PollManager;
import com.github.vladlipovanu.dat250.entities.User;
import com.github.vladlipovanu.dat250.entities.Vote;
import com.github.vladlipovanu.dat250.rabbitConfig.Tut5Sender;
import com.github.vladlipovanu.dat250.requests.CreateVoteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class VoteController {
    private final PollManager pollManager;

    @Autowired(required = false)
    private Tut5Sender message;


    public VoteController(final PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping("/vote")
    public User voteRequest(@RequestBody CreateVoteRequest request) {
        User user = request.getUser();
        if (user.getVotes() == null) {
            user.setVotes(new ArrayList<>());
        }
        user.getVotes().add(request.getVote());
        pollManager.addPoll(request.getPoll(),user);

        if (message != null) {
            Vote vote = request.getVote();
            Long voteOption = (long) vote.getVoteOption();
            Long userId = request.getUser().getId();
            message.sendVote(voteOption,userId);
            System.out.println("Vote published");
        }
        return user;
    }

    @PutMapping("/vote")
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

            if (message != null) {
                Vote vote = request.getVote();
                Long voteOption = (long) vote.getVoteOption();
                Long userId = request.getUser().getId();
                message.sendVote(voteOption, userId);
                System.out.println("Vote published");
            }
            return requestUser;

        }

        if (message != null) {
            Vote vote = request.getVote();
            Long voteOption = (long) vote.getVoteOption();
            Long userId = request.getUser().getId();
            message.sendVote(voteOption, userId);
            System.out.println("Vote published");

        }
        return updatedUser;
    }

    @GetMapping("/vote")
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
