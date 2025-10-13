plugins {
	java
	id("org.springframework.boot") version "3.4.9"
	id("io.spring.dependency-management") version "1.1.7"
	jacoco
}

group = "com.github.vladlipovanu"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot for DAT250."

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.6.0")
	implementation("org.hibernate.orm:hibernate-core:7.1.1.Final")
	implementation("jakarta.persistence:jakarta.persistence-api:3.2.0")
	implementation("com.h2database:h2:2.3.232")
	implementation("redis.clients:jedis:6.2.0")
	implementation("org.springframework.boot:spring-boot-starter-amqp")
	implementation("com.rabbitmq:amqp-client:5.26.0")
	// Tutorial only Rabbit
//	implementation("org.slf4j:slf4j-api:2.0.17")
//	implementation("org.slf4j:slf4j-simple:2.0.17")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.test {
	finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}
tasks.jacocoTestReport {
	dependsOn(tasks.test) // tests are required to run before generating the report
	reports {
		xml.required = true
		csv.required = false
		html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
	}
}

tasks.register<JavaExec>("runPublisher") {
	group = "application"
	description = "Run the RabbitMQ sender"
	classpath = sourceSets["main"].runtimeClasspath
	mainClass.set("com.github.vladlipovanu.dat250.rabbitTesting.Send")
	args = project.findProperty("args")?.toString()?.split(" ") ?: emptyList()
}

tasks.register<JavaExec>("runSubscriber") {
	group = "application"
	description = "Run a RabbitMQ worker"
	classpath = sourceSets["main"].runtimeClasspath
	mainClass.set("com.github.vladlipovanu.dat250.rabbitTesting.Recv")
	args = project.findProperty("args")?.toString()?.split(" ") ?: emptyList()
	standardInput = System.`in`
}


springBoot {
	mainClass.set("com.github.vladlipovanu.dat250.Dat250Application")
}

