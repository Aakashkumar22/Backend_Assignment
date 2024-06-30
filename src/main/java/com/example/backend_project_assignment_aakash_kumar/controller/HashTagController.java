package com.example.backend_project_assignment_aakash_kumar.controller;

import com.example.backend_project_assignment_aakash_kumar.Model.HashTag;
import com.example.backend_project_assignment_aakash_kumar.Model.User;
import com.example.backend_project_assignment_aakash_kumar.service.HashTagService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hashTags")
public class HashTagController {

     @Autowired
     HashTagService hashTagService;



    @PostMapping
    public ResponseEntity<HashTag> createhashTag(@Valid @RequestBody String s) {
        HashTag hashTag = hashTagService.createhashTag(s);
        return ResponseEntity.ok(hashTag);
    }



    @GetMapping("/{id}")
    public ResponseEntity<HashTag> getHashTagById(@PathVariable Long id) {
        return hashTagService.getHashTagById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HashTag> updateHashTag(@PathVariable Long id, @RequestParam String newName) {
        HashTag updatedHashTag = hashTagService.updateHashTag(id, newName);
        if (updatedHashTag != null) {
            return ResponseEntity.ok(updatedHashTag);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHashTag(@PathVariable Long id) {
        if (hashTagService.deleteHashTag(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
