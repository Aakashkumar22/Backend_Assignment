package com.example.backend_project_assignment_aakash_kumar.service;


import com.example.backend_project_assignment_aakash_kumar.Model.Comment;
import com.example.backend_project_assignment_aakash_kumar.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {


    @Autowired
    CommentRepository commentRepository;


    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Optional<Comment> findById(Long commentId) {
        Optional<Comment> existingComment = commentRepository.findById(commentId);

        return existingComment;
    }

    public void deleteCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
