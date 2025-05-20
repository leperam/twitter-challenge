package com.twitter.infrastructure.data.persistence;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

@Configuration
@Component
@Slf4j
public class CassandraConfig {

    @Value("${spring.data.cassandra.contact-points}")
    private String host;
    @Value("${spring.data.cassandra.port}")
    private int port;
    @Value("${spring.data.cassandra.local-datacenter}")
    private String localDatacenter;
    @Value("${spring.data.cassandra.keyspace-name}")
    private String keyspaceName;

    @Bean
    public CqlSession cassandraSession() {

        try (CqlSession adminSession = CqlSession.builder()
                .addContactPoint(new InetSocketAddress(host, port))
                .withLocalDatacenter(localDatacenter)
                .build()) {

            adminSession.execute("""
                CREATE KEYSPACE IF NOT EXISTS \s""" + keyspaceName + """
                WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};
            """);
        }

        return CqlSession.builder()
                .addContactPoint(new InetSocketAddress(host, port))
                .withLocalDatacenter(localDatacenter)
                .withKeyspace(CqlIdentifier.fromCql(keyspaceName))
                .build();
    }


}
