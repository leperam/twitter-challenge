package com.twitter.core.domain;

import com.twitter.infrastructure.data.persistence.FollowerPrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@AllArgsConstructor
@Table("follower")
@Getter
public class Follower {

    @PrimaryKey
    FollowerPrimaryKey followerPrimaryKey;

}
