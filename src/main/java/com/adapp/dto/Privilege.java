package com.adapp.dto;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Dom on 27.06.2016.
 */
@Entity
@Table
@AttributeOverride(name = "id", column = @Column(name = "privilegeId"))
public class Privilege {


    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

    @Column(name = "name",unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Privilege privilege = (Privilege) o;

        if (name != null ? !name.equals(privilege.name) : privilege.name != null) return false;
        if (roles != null ? !roles.equals(privilege.roles) : privilege.roles != null) return false;
        return name != null ? name.equals(privilege.name) : privilege.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
