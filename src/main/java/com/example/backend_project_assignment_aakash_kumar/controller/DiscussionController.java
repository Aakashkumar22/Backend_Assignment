package com.example.backend_project_assignment_aakash_kumar.controller;

import com.example.backend_project_assignment_aakash_kumar.Model.Discussion;
import com.example.backend_project_assignment_aakash_kumar.Model.HashTag;
import com.example.backend_project_assignment_aakash_kumar.service.DiscussionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("discussions")
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;

    @PostMapping
    public ResponseEntity<Discussion> createDiscussion(@Valid @RequestBody Discussion discussion) {
        Discussion createdDiscussion = discussionService.createDiscussion(discussion);
        return ResponseEntity.ok(createdDiscussion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Discussion> updateDiscussion(@PathVariable Long id, @Valid @RequestBody Discussion discussionDetails) {
        Discussion updatedDiscussion = discussionService.updateDiscussion(id, discussionDetails);
        return ResponseEntity.ok(updatedDiscussion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscussion(@PathVariable Long id) {
        discussionService.deleteDiscussion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hashtag")
    public ResponseEntity<List<Discussion>> getDiscussionsByHashtag(@RequestParam Set<HashTag> hashTags) {
        List<Discussion> discussions = discussionService.getDiscussionsByHashtag(hashTags);
        return ResponseEntity.ok(discussions);
    }

    @GetMapping("/text")
    public ResponseEntity<List<Discussion>> getDiscussionsByText(@RequestParam String text) {
        List<Discussion> discussions = discussionService.getDiscussionsByText(text);
        return ResponseEntity.ok(discussions);
    }

}
