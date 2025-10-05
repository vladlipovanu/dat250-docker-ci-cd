package com.github.vladlipovanu.dat250;

import com.github.vladlipovanu.dat250.services.HashPollServiceRedis;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.UnifiedJedis;

import java.util.Map;
import java.util.Set;

@SpringBootTest
public class CachingTest {

    @Autowired
    private Jedis jedis;

    @Autowired
    private HashPollServiceRedis pollService;

    @BeforeEach
    public void setUp() {
        UnifiedJedis jedis = new UnifiedJedis("redis://localhost:6379");

       /*
       Set exercise
        */

        // Step 1 (clearing the initial set)
        jedis.del("users");

        // Step 2
        Set<String> users = jedis.smembers("users");
        System.out.println(users);

        // Step 3
        jedis.sadd("users", "alice");
        System.out.println(jedis.smembers("users"));

        // Step 4
        jedis.sadd("users", "bob");
        System.out.println(jedis.smembers("users"));

        // Step 5
        jedis.srem("users", "alice");
        System.out.println(jedis.smembers("users"));

        // Step 6
        jedis.sadd("users", "eve");
        System.out.println(jedis.smembers("users"));




       /*
       Hash exercise
        */

        // Step 1 (clearing the hash)
        jedis.del("pollJava");


        Map<String, String> poll = jedis.hgetAll("pollJava");
        System.out.println(poll);

        // Step 2 (inserting the first items)
        jedis.hset("pollJava", "id", "03ebcb7b-bd69-440b-924e-f5b7d664af7b");
        jedis.hset("pollJava", "title", "Pineapple on Pizza?");

        String id = jedis.hget("pollJava", "id");
        String title = jedis.hget("pollJava", "title");
        System.out.println("Id: " + id);
        System.out.println("Title: " + title);

        // Step 3 (making the options hash)
        jedis.hset("optionsJava", "caption1", "Yes yammy!");
        jedis.hset("optionsJava", "voteCount1", "269");

        String caption1 = jedis.hget("optionsJava", "caption1");
        String voteCount1 = jedis.hget("optionsJava", "voteCount1");
        System.out.println("caption1: " + caption1);
        System.out.println("voteCount1: " + voteCount1);

        jedis.hset("optionsJava", "caption2", "Mamma mia, nooo.....!");
        jedis.hset("optionsJava", "voteCount2", "268");

        String caption2 = jedis.hget("optionsJava", "caption2");
        String voteCount2 = jedis.hget("optionsJava", "voteCount2");
        System.out.println("caption2: " + caption2);
        System.out.println("voteCount2: " + voteCount2);


        jedis.hset("optionsJava", "caption3", "I do not really care....");
        jedis.hset("optionsJava", "voteCount3", "42");
        String caption3 = jedis.hget("optionsJava", "caption3");
        String voteCount3 = jedis.hget("optionsJava", "voteCount3");
        System.out.println("caption3: " + caption3);
        System.out.println("voteCount3: " + voteCount3);

        Map<String, String> optionsPoll = jedis.hgetAll("optionsJava");


        // Step 4 (combining the two hashes)
        jedis.hmset("pollJava", optionsPoll);

        System.out.println(jedis.hgetAll("optionsJava"));
        System.out.println(jedis.hgetAll("pollJava"));


        jedis.close();
    }

    @Test
    public void testCache() throws InterruptedException {
        String pollId = "pollJava";

        System.out.println("\n--- Cache Test ---\n");

        // First call - slow
        long start = System.currentTimeMillis();
        pollService.getPollData(pollId);
        long time1 = System.currentTimeMillis() - start;
        System.out.println("First call: " + time1 + "ms");

        Thread.sleep(200);

        // Second call - fast (cached)
        start = System.currentTimeMillis();
        pollService.getPollData(pollId);
        long time2 = System.currentTimeMillis() - start;
        System.out.println("Second call: " + time2 + "ms (cached)");

        Thread.sleep(200);

        // Invalidate
        pollService.invalideCache(pollId);

        Thread.sleep(200);

        // Third call - slow again
        start = System.currentTimeMillis();
        pollService.getPollData(pollId);
        long time3 = System.currentTimeMillis() - start;
        System.out.println("Third call: " + time3 + "ms (cache cleared)");

        System.out.println("\n--- Test Complete ---");
    }
}