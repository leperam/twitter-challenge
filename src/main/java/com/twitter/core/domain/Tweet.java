package com.twitter.core.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

@Table
@Getter
@Builder
public class Tweet {

    @PrimaryKeyColumn(type = PARTITIONED)
    private String id;

    @Column("creation_user_id")
    private String creationUserId;
    @Column("content")
    private String content;
    @Column("creation_date")
    private LocalDateTime creationDate;

}
