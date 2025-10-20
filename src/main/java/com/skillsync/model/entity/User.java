package com.skillsync.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String password;

    //one to one - one user have one profile
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    //many to many - users can have many skills
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_skills", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> skills = new HashSet<>();

    // OneToMany: User can own multiple projects
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Project> ownedProjects = new HashSet<>();

    // ManyToMany: User can contribute to multiple projects
    @ManyToMany(mappedBy = "contributors")
    private Set<Project> projects = new HashSet<>();

    //ManyToMany: user roles for JWT auth
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


}
