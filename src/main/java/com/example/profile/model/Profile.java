package com.example.profile.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "profile")
public class Profile {
    
    @Id
    private long userId;
    private String userName;
    private String email;
    private String pass;

    
}
