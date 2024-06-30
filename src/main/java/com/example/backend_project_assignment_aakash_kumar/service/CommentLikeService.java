package com.example.backend_project_assignment_aakash_kumar.service;


import com.example.backend_project_assignment_aakash_kumar.Model.CommentLike;
import com.example.backend_project_assignment_aakash_kumar.Repository.CommentLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentLikeService {


    @Autowired
    CommentLikeRepository commentLikeRepository;


    public CommentLike createCommentLike(CommentLike commentLike) {
        return commentLikeRepository.save(commentLike);
    }



    public Optional<CommentLike> updateCommentLike(Long commentId) {
        Optional<CommentLike> existingComment = commentLikeRepository.findById(commentId);
        return  existingComment;
    }

    public void deleteCommentById(Long commentId) {
        commentLikeRepository.deleteById(commentId);
    }
}
