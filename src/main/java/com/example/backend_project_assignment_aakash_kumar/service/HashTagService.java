package com.example.backend_project_assignment_aakash_kumar.service;

import com.example.backend_project_assignment_aakash_kumar.Model.HashTag;
import com.example.backend_project_assignment_aakash_kumar.Repository.HashTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service

public class HashTagService {

    @Autowired
    HashTagRepository hashtagRepository;


    public HashTag  createhashTag(String name) {
        HashTag hashtag = new HashTag();
        hashtag.setName(name);
        hashtag.setCreatedOn(LocalDateTime.now());
        return hashtagRepository.save(hashtag);
    }

    public Optional<HashTag> getHashTagById(Long id) {
        return hashtagRepository.findById(id);
    }

    public HashTag updateHashTag(Long id, String newName) {
        Optional<HashTag> optionalHashTag = hashtagRepository.findById(id);
        if (optionalHashTag.isPresent()) {
            HashTag hashtag = optionalHashTag.get();
            hashtag.setName(newName);
            return hashtagRepository.save(hashtag);
        }
        return null; // Or throw an exception if desired
    }

    public boolean deleteHashTag(Long id) {
        Optional<HashTag> optionalHashTag = hashtagRepository.findById(id);
        if (optionalHashTag.isPresent()) {
            hashtagRepository.delete(optionalHashTag.get());
            return true;
        }
        return false;
    }


}
