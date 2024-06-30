package com.example.backend_project_assignment_aakash_kumar.Repository;

import com.example.backend_project_assignment_aakash_kumar.Model.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowerRepository extends JpaRepository<Follower, Long> {

    // Define custom queries if needed
}
