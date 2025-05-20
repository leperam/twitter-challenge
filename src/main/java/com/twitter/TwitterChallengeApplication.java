package com.twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
public class TwitterChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterChallengeApplication.class, args);
	}

}
