package com.example.backend_project_assignment_aakash_kumar.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Data
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotEmpty
    private String text;

    private String imageUrl;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "discussion_hashtag",
            joinColumns = @JoinColumn(name = "discussion_id"),
            inverseJoinColumns = @JoinColumn(name = "hashtag_id")
    )
    private Set<HashTag> hashTags;

    private LocalDateTime createdOn;

    @OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL)
    private Set<Like> likes;

    @OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL)
    private Set<ViewCount> viewCounts;

}
