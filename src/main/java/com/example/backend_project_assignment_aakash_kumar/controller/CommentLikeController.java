package com.example.backend_project_assignment_aakash_kumar.controller;


import com.example.backend_project_assignment_aakash_kumar.Model.CommentLike;
import com.example.backend_project_assignment_aakash_kumar.service.CommentLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment-likes")
public class CommentLikeController {



    @Autowired
    CommentLikeService commentLikeService;


    @PostMapping
    public ResponseEntity<CommentLike> createCommentLike(@RequestBody CommentLike commentLike) {
        CommentLike createdCommentLike = commentLikeService.createCommentLike(commentLike);
        return ResponseEntity.ok(createdCommentLike);
    }
}
