package com.skillsync.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProjectDTO {
    private Long id;
    private String title;
    private String description;
    private String owner;
    private Set<String> contributors;

}
