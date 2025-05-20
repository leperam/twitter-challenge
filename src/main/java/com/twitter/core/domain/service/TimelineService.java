package com.twitter.core.domain.service;

import com.twitter.core.domain.Tweet;
import com.twitter.core.domain.UserTimeline;
import com.twitter.infrastructure.data.persistence.UserTimelineRepository;
import com.twitter.infrastructure.data.persistence.UserTimelinePrimaryKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineService {

    @Autowired
    private UserTimelineRepository userTimelineRepository;

    public void saveTweetATimelineOf(final String followedUserId, final Tweet tweet) {

        final UserTimeline userTimelineEntry = UserTimeline.builder()
                .userTimelinePrimaryKey(new UserTimelinePrimaryKey(followedUserId, tweet.getCreationDate()))
                .creationUserId(tweet.getCreationUserId())
                .tweetContent(tweet.getContent())
                .build();
        userTimelineRepository.save(userTimelineEntry);
    }

    public List<UserTimeline> getTimelineEntries(final String currentUser) {
        return userTimelineRepository.findUserTimelineOf(currentUser);
    }
}
