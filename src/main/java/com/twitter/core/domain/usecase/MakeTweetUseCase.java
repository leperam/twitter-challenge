package com.twitter.core.domain.usecase;

import com.twitter.api.request.TweetRequest;
import com.twitter.core.domain.Follower;
import com.twitter.core.domain.Tweet;
import com.twitter.core.domain.service.FollowService;
import com.twitter.core.domain.service.TimelineService;
import com.twitter.core.domain.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakeTweetUseCase {

    @Autowired
    private TweetService tweetService;

    @Autowired
    private FollowService followService;

    @Autowired
    private TimelineService timelineService;

    public void execute(String currentUser, final TweetRequest request){
        final Tweet tweet = tweetService.saveTweet(currentUser, request);

        final List<Follower> followers = followService.findAllFollowersOf(currentUser);

        followers.forEach(follower -> {
            timelineService.saveTweetATimelineOf(follower.getFollowerPrimaryKey().getFollowerUserId(), tweet);
        });

    }

}