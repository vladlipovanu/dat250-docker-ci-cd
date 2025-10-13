**This is the report for the construction of Assignment 6**

**Step 0**
1. For this assignment, I chose to work with the _**AMQP Protocol**_ using **_RabbitMQ_** as my message broker.
2. Since I don't have any experience working, I tried to follow the tutorial on their website. At first I started with the simple version which it doesn't include Spring.
3. After I felt a bit more confided I started to do some of the tutorials for Spring. Some of the parts of the tutorial where a bit hard to understand from my perspective, I searched on Google to see if I can find some alternatives. I also consulted the examples from our course.
4. After some try-and-errors with setting up the code from the tutorial and testing, I managed to have a decent build which I concluded it will be enough to do the assignment.

**Step 1**
1. I had a bit of difficulties to come up with how to incorporate the tutorial code to work with the current build for the Poll Manager.
2. I falled back on one of the tutorials which I readed earlier, and started small from there. Again, after try-and-errors, I managed to have a simple system in which a queue for a Poll will be created (the topic), and thus the votes (clients) will be able to register their vote.
3. I'm aware that the build I made is not completed, meaning that there is no data yet into a database, but the broker system works as intended after calling the endpoint for testing.

**Side Note**
1. I always forget to open the Docker Desktop application in order for the servers to work.


![Assignment 6 Rabbit 1.png](../pictures/Assignment%206%20Rabbit%201.png)

![Assignment 6 Rabbit 2.png](../pictures/Assignment%206%20Rabbit%202.png)

![Assignment 6 Rabbit 3.png](../pictures/Assignment%206%20Rabbit%203.png)

![Assignment 6 Rabbit 4.png](../pictures/Assignment%206%20Rabbit%204.png)

![Assignment 6 Rabbit 5.png](../pictures/Assignment%206%20Rabbit%205.png)