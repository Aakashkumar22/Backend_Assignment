package com.example.backend_project_assignment_aakash_kumar.Repository;

import com.example.backend_project_assignment_aakash_kumar.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(Long id);
    List<User> findByNameContaining(String name);
    User findByEmail(String email);
}
