**This is the report for the construction of Assignment 7**

**Step 0**
1. I have done the Docker installation from the first assignment, so I just doubled checked again with the command in order to make sure that everything is ok.

![Docker 1.png](../pictures/%2FDocker%201.png)

**Step 1**
1. I already had a Dockerfile from previous assignments. I had a look at the example provided from the lectures and did some changes in order to make it work.
2. When I was ready to do the image, I had a typo error in the file, which was a quick fix.
3. After that, I run the following commands on the Docker Desktop app:

**_docker tag dat250-pollapp learningexperience96/dat250-pollapp:v1_**

**_docker push learningexperience96/dat250-pollapp:v1_**

4. I just needed to wait for the image to be pushed. When it was done, I could run the image on the Docker app in order for my backend to work. For the port, I chose to use the same as Spring (8080).

![Docker Assignment 2.png](../pictures/%2FDocker%20Assignment%202.png)

![Docker Assignment 3.png](../pictures/%2FDocker%20Assignment%203.png)

![Docker Assignment 4.png](../pictures/%2FDocker%20Assignment%204.png)

5. I wanted to have the version to run on a cloud, in order to be easier in the future to showcase. For this I tried first with Azure, with the Student profile, but it appears that it wasn't good enough (I didn't have enough quota for some reasons). After searching for alternatives, I found out that I could host it for free on **_www.render.com_**. It has some downsides, since is on a free plan and it doesn't run 24/7, but I can easily turn it on when needed. The link to it is: **_https://vlad-pollapp.onrender.com/votes_**

![Docker Assignment 5.png](../pictures/%2FDocker%20Assignment%205.png)

**Side Note:**
The project is not finished yet. I find it intersting and I would like to work on it a bit more (for future showcases and getting experience), but right now I have a family issue that it takes a lot of my time. 
So on the website that I host, the data in the components are just placeholders. I want to implement it later with API callings from the backend. I would also like to have a relational database (I'm more familiar with PostSQL) in order to make a functional application. I will also like to work more with RabbitMQ in order to make an exchange system, as well as fixing the pipelines for testing.
