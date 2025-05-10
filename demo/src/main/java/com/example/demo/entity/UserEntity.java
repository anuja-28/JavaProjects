package com.example.demo.entity;

import com.example.demo.model.DeleteStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(name = "user_pwd", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_delete_status", nullable = false)
    private DeleteStatus userDeleteStatus;

    // Getters and setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public DeleteStatus getUserDeleteStatus() { return userDeleteStatus; }

    public void setUserDeleteStatus(DeleteStatus userDeleteStatus) {
        this.userDeleteStatus = userDeleteStatus;
    }
}




// Imagine a user registration:

// entity/User.java → represents the user in the DB

// dto/UserDTO.java → represents the user for API response

// controller/UserController.java → handles /register route

// service/UserService.java → creates user, encrypts password

// repository/UserRepository.java → saves to DB

// templates/register.html → form for user input

// 🔐 Why this structure?
// ✅ Secure (DTOs avoid exposing private fields)

// ✅ Scalable (easy to manage large apps)

// ✅ Clean (each layer does one job)