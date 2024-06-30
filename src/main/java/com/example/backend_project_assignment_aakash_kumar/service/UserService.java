package com.example.backend_project_assignment_aakash_kumar.service;

import com.example.backend_project_assignment_aakash_kumar.Model.User;
import com.example.backend_project_assignment_aakash_kumar.Repository.UserRepository;
import com.example.backend_project_assignment_aakash_kumar.dtos.UserReqdto;
import com.example.backend_project_assignment_aakash_kumar.dtos.Userdto;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        user.setMobile(userDetails.getMobile());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        return userRepository.save(user);

    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public List<User> searchUsersByName(String name) {
        return userRepository.findByNameContaining(name);
    }

    public Userdto signup(UserReqdto userReqdto) {
        User us=User.builder().name(userReqdto.getName())
                .email(userReqdto.getEmail())
                .mobile(userReqdto.getMobile())
                .password(bCryptPasswordEncoder.encode(userReqdto.getPassword()))
                .discussions(userReqdto.getDiscussions())
                .build();
        User udb=userRepository.save(us);
        return Userdto .from(udb);
    }
}


