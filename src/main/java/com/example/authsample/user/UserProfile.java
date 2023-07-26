package com.example.authsample.user;

import com.example.authsample.common.model.ReferenceBase;
import jakarta.persistence.*;

@Entity
@Table(name = "user_profile")
public class UserProfile extends ReferenceBase {

    private String username;
    private String password;
    private UserRole userRole;
    private String name;
    private String email;

    @Column(name = "username", unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JoinColumn(name = "user_role_id")
    @ManyToOne
    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
