package com.twitter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.CassandraContainer;

@SpringBootTest
class TwitterChallengeApplicationTests {

	static CassandraContainer<?> cassandraContainer = new CassandraContainer<>("cassandra:4.1");

	@BeforeAll
	static void startContainer() {
		cassandraContainer.start();
		System.setProperty("spring.data.cassandra.contact-points", cassandraContainer.getHost());
		System.setProperty("spring.data.cassandra.port", cassandraContainer.getFirstMappedPort().toString());
		System.setProperty("spring.data.cassandra.schema-action", "CREATE_IF_NOT_EXISTS");
	}

	@Test
	void contextLoads() {
	}

}
