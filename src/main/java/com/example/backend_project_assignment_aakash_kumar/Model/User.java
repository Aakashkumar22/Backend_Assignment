package com.example.backend_project_assignment_aakash_kumar.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotEmpty
        private String name;

        @NotEmpty
        @Column(unique = true)
        private String mobile;

        @Email
        @NotEmpty
        @Column(unique = true)
        private String email;

        @NotEmpty
        private String password;

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
        private Set<Discussion> discussions;



}

