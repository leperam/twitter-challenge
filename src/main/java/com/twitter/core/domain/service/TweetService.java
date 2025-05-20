package com.twitter.core.domain.service;

import com.twitter.api.request.TweetRequest;
import com.twitter.core.domain.Tweet;
import com.twitter.infrastructure.data.persistence.TweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TweetService {

    @Autowired
    private TweetsRepository tweetsRepository;

    public Tweet saveTweet(final String currentUser, final TweetRequest request){
        final Tweet tweet = Tweet.builder()
                .id(UUID.randomUUID().toString())
                .content(request.getContent())
                .creationDate(LocalDateTime.now())
                .creationUserId(currentUser)
                .build();
        return tweetsRepository.save(tweet);
    }
}
