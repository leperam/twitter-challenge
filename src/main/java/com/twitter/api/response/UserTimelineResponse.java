package com.twitter.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class UserTimelineResponse {

    private String followerUserId;
    private LocalDateTime creationDate;
    private String creationUserId;
    private String tweetContent;
}
