package com.twitter.core.domain.service;

import com.twitter.core.domain.Follower;
import com.twitter.infrastructure.data.persistence.FollowerPrimaryKey;
import com.twitter.infrastructure.data.persistence.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    @Autowired
    private FollowerRepository followerRepository;

    public List<Follower> findAllFollowersOf(final String currentUser){
        return followerRepository.findFollowersOf(currentUser);
    }

    public void save(final String currentUser, final String followedUserId){
        followerRepository.save(new Follower(new FollowerPrimaryKey(currentUser, followedUserId)));
    }


}