package org.asodev.rentacar.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "UserID",columnDefinition = "BINARY(16)")
    private Long userID;

    @Column(name = "Username",nullable = false,unique = true)
    private String username;

    @Column(name = "Email",nullable = false,unique = true)
    private String email;

    @Column(name = "Password",nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "UserRoles",
            joinColumns = @JoinColumn(name = "UserID"),
            inverseJoinColumns = @JoinColumn(name = "RoleId"))
    private Set<Role> roles;

    @Column(name = "IsActive")
    private boolean isActive;

    public User() {
    }

    public User(Long userID, String username, String email, String password, Set<Role> roles, boolean isActive) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.isActive = isActive;
    }


}
