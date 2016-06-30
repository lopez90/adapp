package com.adapp.dto;

import com.adapp.dao.interf.RoleDAO;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Dom on 27.06.2016.
 */
@Entity
@Table
@AttributeOverride(name = "id", column = @Column(name = "roleId"))

public class Role extends BaseEntity {
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_privilege",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "privilegeId"))
    private Collection<Privilege> privileges;

    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "description")
    private String description;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (users != null ? !users.equals(role.users) : role.users != null) return false;
        if (privileges != null ? !privileges.equals(role.privileges) : role.privileges != null) return false;
        if (name != null ? !name.equals(role.name) : role.name != null) return false;
        return description != null ? description.equals(role.description) : role.description == null;

    }

    @Override
    public int hashCode() {
        int result = users != null ? users.hashCode() : 0;
        result = 31 * result + (privileges != null ? privileges.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
