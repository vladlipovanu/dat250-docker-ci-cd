# ---- test stage ----
FROM gradle:8.7-jdk21 AS test
WORKDIR /workspace
COPY . .
RUN gradle test --no-daemon

# ---- build stage ----
FROM gradle:8.7-jdk21 AS build
WORKDIR /workspace
COPY . .
RUN gradle clean bootJar --no-daemon

# ---- runtime stage ----
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# copy the built jar (adjust name if not SNAPSHOT)
COPY --from=build /workspace/build/libs/*SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
