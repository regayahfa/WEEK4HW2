package com.example.week4hw2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class User {
    @Id
    @NotEmpty
    private int ID;
    @NotEmpty(message = "name cannot be null")
    @Min(4)
    private String name;
    @NotEmpty(message = "username cannot be null")
    @Min(4)
    @Column(columnDefinition = "unique")
    private String username;
    @NotEmpty(message = "pass cannot be null")
    private String passowrd;
    @NotEmpty(message = "cannot be null")
    @Column(columnDefinition = "unique")
    @Email(message = "must be valid email")
    private String email;
    @NotEmpty(message = "role connot be null")
    @Column(columnDefinition = "check(role='user' or role='admin")
    private  String role;
    @NotEmpty(message = " age must be valid email")
    @Positive
    private int age;
}
