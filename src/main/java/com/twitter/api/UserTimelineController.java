package com.twitter.api;

import com.twitter.api.response.UserTimelineResponse;
import com.twitter.core.domain.UserTimeline;
import com.twitter.core.domain.usecase.GetUserTimelineUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/timeline")
public class UserTimelineController {

    @Autowired
    private GetUserTimelineUseCase getUserTimelineUseCase;

    @GetMapping
    public ResponseEntity<List<UserTimelineResponse>> getTimeline(@RequestHeader("user-id") final String currentUser){
        List<UserTimeline> userTimelineEntries = getUserTimelineUseCase.execute(currentUser);

        List<UserTimelineResponse> userTimelineResponses = userTimelineEntries.stream()
                .map(u -> new UserTimelineResponse(u.getUserTimelinePrimaryKey().getFollowerUserId(),
                        u.getUserTimelinePrimaryKey().getCreationDate(),
                        u.getCreationUserId(),
                        u.getTweetContent()))
                .toList();
        // FIXME Improvement: Return a pageable instead of a list
        return ResponseEntity.ok(userTimelineResponses);
    }



}
