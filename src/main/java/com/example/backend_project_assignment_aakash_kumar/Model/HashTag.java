package com.example.backend_project_assignment_aakash_kumar.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Data

public class HashTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    public void setCreatedOn(LocalDateTime now) {
    }

    //@ManyToMany(mappedBy = "hashTags")
    //private Set<Discussion> discussions;
}
