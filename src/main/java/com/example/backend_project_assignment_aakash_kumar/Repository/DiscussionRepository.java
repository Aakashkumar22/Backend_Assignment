package com.example.backend_project_assignment_aakash_kumar.Repository;

import com.example.backend_project_assignment_aakash_kumar.Model.Discussion;
import com.example.backend_project_assignment_aakash_kumar.Model.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository

public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
        List<Discussion> findByHashTags(Set<HashTag> hashTags);
        List<Discussion> findByTextContaining(String text);
    }

