**This is the report for the construction of Assignment 2**

**Step 0**
1. From the first assignment, I have chosen to use IntelliJ as my IDE for this subject, and did the appropriate configurations presented in the problem description from Assignment 1.
2. I have access the HTTP Client plugin for IntelliJ for configuration, which can be found here: https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html
3. I made a new http client which will be used for testing later.

**Step 1**
1. Since I set up the CI/CD pipeline from the previous assignment (in which I needed to create a repo on GitHub) I decided to use it for this assignment. I did the appropriate configurations in order to "transfer" this project into the repo, but I encounter some difficulties with passing the tests on GitHub, so I had to do some searching in order to configure it to work (this is related from Assignment 1).

**Step 2**
1. I started creating a folder name dto (I m thinking this will serve for it later, since we will need to implement entities with ORM later maybe) in the java folder for the main, which is for the domains presented in the assignment description. 
2. Afterward, I created the classes as shown in the diagram and described in the assignment description.

**Step 3**
1. Going back to the http client I created from **Step 0**, I checked the documentation again and reviewed some examples from the plugin description. I then created some simple samples based on the examples shown.
2. I started to run the tests, but I noticed that all the test were returning 404 status error code. I assumed this was ok for now since there was no mapping or any functions.

**Step 4**
1. I started by creating a new package called controllers in the main Java folder. Afterward, I needed a refresher on Spring and Java since I hadn't worked with them for a while. Looking at the API tests I had created for the HTTP client, I began implementing the controllers and mappings accordingly. While implementing them one by one, I tested each endpoint to ensure the responses were as expected.

**Step 5**
1. I checked again for the documentation of the HTTP Client to see how to automate the tests. I followed the examples from there.

**Step 6**
1. I did what was required from the assignment, and the Swagger worked fine.

**Step 7**
1. Hard to implement, working on it.
