package com.example.backend_project_assignment_aakash_kumar.service;


import com.example.backend_project_assignment_aakash_kumar.Model.Follower;
import com.example.backend_project_assignment_aakash_kumar.Repository.FollowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerService {

    private final FollowerRepository followerRepository;

    public FollowerService(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }


    public List<Follower> getAllFollowers() {
        return followerRepository.findAll();
    }

    public Follower saveFollower(Follower follower) {
        return followerRepository.save(follower);
    }

}
