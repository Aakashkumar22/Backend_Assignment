package com.example.backend_project_assignment_aakash_kumar.service;

import com.example.backend_project_assignment_aakash_kumar.Model.HashTag;
import com.example.backend_project_assignment_aakash_kumar.Model.Like;
import com.example.backend_project_assignment_aakash_kumar.Repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    LikeRepository likeRepository;


    public Like createLike(Like like) {
        return likeRepository.save(like);
    }

    public Optional<Like> getLikeById(Long id) {
        return likeRepository.findById(id);
    }

    public Like updateLike(Long id, String newName) {
        Optional<Like> optionalHashTag = likeRepository.findById(id);
        if (optionalHashTag.isPresent()) {
            Like like = optionalHashTag.get();
            like.setName(newName);
            return like;
        }
        return null; // Or throw an exception if desired
    }

    public void deleteLikeById(Long id) {
        likeRepository.deleteById(id);
    }

    public void saveLike(Long discussionId, Long userId) {
        likeRepository.saveLike(20L, 11L);
    }








}
