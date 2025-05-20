package com.twitter.infrastructure.data.persistence;

import com.twitter.core.domain.Follower;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowerRepository extends CassandraRepository<Follower, FollowerPrimaryKey> {

    @Query("SELECT * FROM follower WHERE followed_id = ?0")
    List<Follower> findFollowersOf(String currentUser);
}
