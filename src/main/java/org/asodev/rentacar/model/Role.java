package org.asodev.rentacar.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "RoleID",columnDefinition = "BINARY(16)")
    private UUID roleID;

    @Column(name = "name",nullable = false,unique = true)
    private String name;

    public Role() {
    }

    public Role(UUID roleID, String name) {
        this.roleID = roleID;
        this.name = name;
    }

    public UUID getRoleID() {
        return roleID;
    }

    public void setRoleID(UUID roleID) {
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(roleID, role.roleID) && Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleID, name);
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleID=" + roleID +
                ", name='" + name + '\'' +
                '}';
    }
}
