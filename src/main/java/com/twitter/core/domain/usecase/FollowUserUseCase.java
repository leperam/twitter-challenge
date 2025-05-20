package com.twitter.core.domain.usecase;

import com.twitter.api.request.FollowRequest;
import com.twitter.core.domain.service.FollowService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public class FollowUserUseCase {

    @Autowired
    private FollowService followService;

    public void execute(final String currentUser, final FollowRequest request){
        followService.save(currentUser, request.getUserFollowedId());
    }
}
