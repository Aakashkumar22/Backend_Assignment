package com.example.backend_project_assignment_aakash_kumar.controller;


import com.example.backend_project_assignment_aakash_kumar.Jwt.JwtUtil;
import com.example.backend_project_assignment_aakash_kumar.Model.User;
import com.example.backend_project_assignment_aakash_kumar.Repository.UserRepository;
import com.example.backend_project_assignment_aakash_kumar.dtos.UserReqdto;
import com.example.backend_project_assignment_aakash_kumar.dtos.Userdto;
import com.example.backend_project_assignment_aakash_kumar.service.CustomUserDetailsService;
import com.example.backend_project_assignment_aakash_kumar.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(" user id with the id"+id+"has been deleted Successfully");
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsersByName(@RequestParam String name) {
        List<User> users = userService.searchUsersByName(name);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/h")
    public  String gethello(){
        return "Hola";
    }



    @PostMapping("/signup/user")
    public ResponseEntity<Userdto> signup(@RequestBody UserReqdto userReqdto) {
        Userdto userDto = userService.signup(userReqdto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @GetMapping("/signin/user")
    public  ResponseEntity<?> getsignin(){
        return null;

    }
}
