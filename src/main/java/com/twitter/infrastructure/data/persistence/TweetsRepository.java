package com.twitter.infrastructure.data.persistence;

import com.twitter.core.domain.Tweet;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TweetsRepository extends CassandraRepository<Tweet, String> {


}
