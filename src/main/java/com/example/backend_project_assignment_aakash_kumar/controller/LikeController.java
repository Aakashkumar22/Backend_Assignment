package com.example.backend_project_assignment_aakash_kumar.controller;

import com.example.backend_project_assignment_aakash_kumar.Model.Like;
import com.example.backend_project_assignment_aakash_kumar.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("likes")
public class LikeController {



    @Autowired
    LikeService likeService;


    @PostMapping
    public ResponseEntity<Like> createLike(@RequestBody Like like) {
        Like createdLike = likeService.createLike(like);
        return ResponseEntity.ok(createdLike);
    }


    // Add other endpoints as needed (update, delete, etc.)
}
