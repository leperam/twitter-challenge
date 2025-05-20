package com.twitter.api;

import com.twitter.api.request.TweetRequest;
import com.twitter.core.domain.Tweet;
import com.twitter.core.domain.usecase.MakeTweetUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tweet")
public class TweetController {

    @Autowired
    private MakeTweetUseCase makeTweetUseCase;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> makeTweet(@RequestHeader("user-id") final String currentUser,
                                           @RequestBody TweetRequest request){
        makeTweetUseCase.execute(currentUser, request);
        return ResponseEntity.accepted().build();
    }

}
