package com.example.backend_project_assignment_aakash_kumar.service;

import com.example.backend_project_assignment_aakash_kumar.Model.Discussion;
import com.example.backend_project_assignment_aakash_kumar.Model.HashTag;
import com.example.backend_project_assignment_aakash_kumar.Repository.DiscussionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service

public class DiscussionService {

    @Autowired
    private DiscussionRepository discussionRepository;

    @Autowired
    HashTagService hashTagService;

    @Transactional
    public Discussion createDiscussion(Discussion discussion) {
        // Fetch or merge HashTag entities if necessary
        Set<HashTag> hashTags = new HashSet<>();
        for (HashTag hashtag : discussion.getHashTags()) {
            HashTag existingHashTag = hashTagService.getHashTagById(hashtag.getId()).orElse(null);
            if (existingHashTag != null) {
                hashTags.add(existingHashTag);  // Reattach existing hash tag
            } else {
                // Handle case where hash tag is new or not found
                // You may choose to throw an exception or handle differently
            }
        }
        discussion.setHashTags(hashTags);  // Set reattached hash tags

        // Save discussion
        return discussionRepository.save(discussion);
    }

    public Discussion updateDiscussion(Long id, Discussion discussionDetails) {
        Discussion discussion = discussionRepository.findById(id).orElseThrow(() -> new RuntimeException("Discussion not found"));
        discussion.setText(discussionDetails.getText());
        //discussion.setImage(discussionDetails.getImage());
        //discussion.setHashtags(discussionDetails.getHashtags());
        return discussionRepository.save(discussion);
    }

    public void deleteDiscussion(Long id) {
        Discussion discussion = discussionRepository.findById(id).orElseThrow(() -> new RuntimeException("Discussion not found"));
        discussionRepository.delete(discussion);
    }

    public List<Discussion> getDiscussionsByHashtag(Set<HashTag> hashTags) {
        return discussionRepository.findByHashTags(hashTags);
    }

    public List<Discussion> getDiscussionsByText(String text) {
        return discussionRepository.findByTextContaining(text);
    }
}
