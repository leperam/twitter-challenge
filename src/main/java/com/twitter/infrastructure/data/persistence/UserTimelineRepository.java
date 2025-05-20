package com.twitter.infrastructure.data.persistence;

import com.twitter.core.domain.UserTimeline;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTimelineRepository extends CassandraRepository<UserTimeline, UserTimelinePrimaryKey> {

    @Query("SELECT * FROM user_timeline WHERE follower_user_id = ?0 ORDER BY creation_date")
    List<UserTimeline> findUserTimelineOf(String currentUser);

}
