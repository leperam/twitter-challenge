package com.twitter.core.domain;

import com.twitter.infrastructure.data.persistence.UserTimelinePrimaryKey;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

@Table("user_timeline")
@Builder
@Getter
public class UserTimeline {

    @PrimaryKey
    private UserTimelinePrimaryKey userTimelinePrimaryKey;

    @Column("creation_user_id")
    private String creationUserId;

    @Column("tweet_content")
    private String tweetContent;

}
