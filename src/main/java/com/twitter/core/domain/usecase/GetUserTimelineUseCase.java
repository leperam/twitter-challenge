package com.twitter.core.domain.usecase;

import com.twitter.core.domain.UserTimeline;
import com.twitter.core.domain.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserTimelineUseCase {

    @Autowired
    private TimelineService timelineService;

    public List<UserTimeline> execute(final String currentUser) {
        return timelineService.getTimelineEntries(currentUser);
    }
}
