package com.example.backend_project_assignment_aakash_kumar.dtos;

import com.example.backend_project_assignment_aakash_kumar.Model.Discussion;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserReqdto {
    private Long id;
    private String name;
    private String mobile;
    private String email;
    private String password;
    private Set<Discussion> discussions;
}
