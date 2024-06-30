package com.example.backend_project_assignment_aakash_kumar.dtos;

import com.example.backend_project_assignment_aakash_kumar.Model.Discussion;
import com.example.backend_project_assignment_aakash_kumar.Model.User;
import lombok.*;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Userdto {

    private Long id;
    private String name;
    private String mobile;
    private String email;
    private String password;
    private Set<Discussion> discussions;

    public Userdto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.mobile = user.getMobile();
    }

    public static  Userdto from (User user){
        Userdto ans= Userdto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .mobile(user.getMobile())
                .password(user.getPassword())
                .discussions(user.getDiscussions()).build();

        return ans;

    }



    }

