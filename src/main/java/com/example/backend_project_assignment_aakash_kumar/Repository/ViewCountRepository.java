package com.example.backend_project_assignment_aakash_kumar.Repository;

import com.example.backend_project_assignment_aakash_kumar.Model.ViewCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ViewCountRepository extends JpaRepository<ViewCount, Long> {
    Optional<ViewCount> findById(Long viewCountId);
    // Add custom query methods if needed
}
