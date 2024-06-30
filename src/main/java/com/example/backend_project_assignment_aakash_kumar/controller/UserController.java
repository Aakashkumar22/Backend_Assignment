package com.example.backend_project_assignment_aakash_kumar.controller;


import com.example.backend_project_assignment_aakash_kumar.Model.User;
import com.example.backend_project_assignment_aakash_kumar.dtos.UserReqdto;
import com.example.backend_project_assignment_aakash_kumar.dtos.Userdto;
import com.example.backend_project_assignment_aakash_kumar.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

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

    @PostMapping("/signup")
    public ResponseEntity<Userdto> signup(@RequestBody UserReqdto userReqdto){
        Userdto Us=userService.signup(userReqdto);
        return new ResponseEntity<>(Us, HttpStatus.CREATED);
    }

    @GetMapping("/signin")
    public  ResponseEntity<?> getsignin(){
        return new ResponseEntity<>(10,HttpStatus.OK);
    }
}
