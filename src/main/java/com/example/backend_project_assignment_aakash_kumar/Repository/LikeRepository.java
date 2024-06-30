package com.example.backend_project_assignment_aakash_kumar.Repository;

import com.example.backend_project_assignment_aakash_kumar.Model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    // Add custom query methods if needed
    @Modifying
    @Query(value = "INSERT INTO `Like` (discussion_id, user_id) VALUES (:discussionId, :userId)", nativeQuery = true)
    void saveLike(@Param("discussionId") Long discussionId, @Param("userId") Long userId);
}
