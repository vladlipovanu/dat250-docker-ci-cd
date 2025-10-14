# ---- test stage ----
FROM gradle:8.14.3-alpine AS test
WORKDIR /home/gradle

# copy config files
COPY settings.gradle.kts build.gradle.kts ./
COPY src src
COPY gradle gradle

# run tests
RUN gradle test --no-daemon


# ---- build stage ----
FROM gradle:8.14.3-alpine AS builder
WORKDIR /home/gradle

# copy config files
COPY settings.gradle.kts build.gradle.kts ./
COPY src src
COPY gradle gradle

# build the app
RUN gradle clean bootJar --no-daemon


# rename and move the resulting JAR file
RUN mv build/libs/*SNAPSHOT.jar app.jar

# ---- runtime stage ----
FROM eclipse-temurin:21-alpine

# create a non-root user
RUN addgroup -g 1000 app && \
    adduser -G app -D -u 1000 -h /app app

# switch the users
USER app
WORKDIR /app

# copy JAR
COPY --from=builder --chown=1000:1000 /home/gradle/app.jar .

# document the port
EXPOSE 8080

# start the Spring Boot application
ENTRYPOINT ["java","-jar","app.jar"]
