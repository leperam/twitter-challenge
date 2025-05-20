package com.twitter.infrastructure.data.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.time.LocalDateTime;

@PrimaryKeyClass
@AllArgsConstructor
@Getter
public class UserTimelinePrimaryKey {

    @PrimaryKeyColumn(name = "follower_user_id", type = PrimaryKeyType.PARTITIONED)
    private String followerUserId;

    @PrimaryKeyColumn(name = "creation_date", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private LocalDateTime creationDate;
}