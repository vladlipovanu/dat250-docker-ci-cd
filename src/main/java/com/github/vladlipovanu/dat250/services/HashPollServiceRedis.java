package com.github.vladlipovanu.dat250.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Map;

@Service
public class HashPollServiceRedis {

    @Autowired
    private Jedis jedis;


    @Cacheable(value = "pollVotes", key = "#pollId")
    public Map<String, String> getPollData(String pollId) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return jedis.hgetAll(pollId);
    }

    @CacheEvict(value = "pollVotes", key = "#pollId")
    public void invalideCache(String pollId) {
        System.out.println("Cache invalide for: " + pollId);
    }

    @CacheEvict(value = "pollVotes", key = "#pollId")
    public void incrementVote(String pollId, String voteCount) {
        jedis.hincrBy(pollId, voteCount, 1);
    }
}
