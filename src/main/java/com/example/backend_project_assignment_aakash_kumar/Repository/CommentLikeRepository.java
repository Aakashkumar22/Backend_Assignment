package com.example.backend_project_assignment_aakash_kumar.Repository;

import com.example.backend_project_assignment_aakash_kumar.Model.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {
    // Add custom query methods if needed
}
