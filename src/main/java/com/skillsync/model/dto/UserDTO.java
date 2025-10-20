package com.skillsync.model.dto;

import com.skillsync.model.entity.Skill;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private Set<String> skills;
    private Set<String> roles;
}
