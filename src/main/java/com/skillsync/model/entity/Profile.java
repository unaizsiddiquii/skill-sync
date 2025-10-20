package com.skillsync.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String fullName;
    private String bio;
    private String location;

    //owning side
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
