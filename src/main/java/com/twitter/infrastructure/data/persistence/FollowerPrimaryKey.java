package com.twitter.infrastructure.data.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;

@PrimaryKeyClass
@Getter
@AllArgsConstructor
public class FollowerPrimaryKey implements Serializable {

    @PrimaryKeyColumn(name = "follower_id", type = PrimaryKeyType.CLUSTERED)
    private String followerUserId;

    @PrimaryKeyColumn(name = "followed_id", type = PrimaryKeyType.PARTITIONED)
    private String followedUserId;

}
