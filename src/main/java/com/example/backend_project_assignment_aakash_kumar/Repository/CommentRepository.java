package com.example.backend_project_assignment_aakash_kumar.Repository;


import com.example.backend_project_assignment_aakash_kumar.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findById(Long commentId);
    // Add custom query methods if needed
}
