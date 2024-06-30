package com.example.backend_project_assignment_aakash_kumar.controller;

import com.example.backend_project_assignment_aakash_kumar.Model.Follower;
import com.example.backend_project_assignment_aakash_kumar.service.FollowerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("followers")
public class FollowerController {

    private final FollowerService followerService;

    public FollowerController(FollowerService followerService) {
        this.followerService = followerService;
    }



    @PostMapping
    public ResponseEntity<Follower> createFollower(@RequestBody Follower follower) {
        Follower createdFollower = followerService.saveFollower(follower);
        return new ResponseEntity<>(createdFollower, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Follower>> getallfollwers(){
        List<Follower>getfollwer = (List<Follower>) followerService.getAllFollowers();
        return new ResponseEntity<>(getfollwer, HttpStatus.CREATED);
    }
}
