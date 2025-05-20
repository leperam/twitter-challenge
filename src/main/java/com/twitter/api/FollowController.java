package com.twitter.api;

import com.twitter.api.request.FollowRequest;
import com.twitter.core.domain.usecase.FollowUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/follow")
public class FollowController {

    @Autowired
    private FollowUserUseCase followUserUseCase;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> makeTweet(@RequestHeader("user-id") final String currentUser,
                                    @RequestBody FollowRequest request){
        followUserUseCase.execute(currentUser, request);
        return ResponseEntity.accepted().build();
    }

}
