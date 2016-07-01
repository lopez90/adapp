package com.adapp.dto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * Created by Dom on 27.06.2016.
 */
@Entity
@Table
@AttributeOverride(name = "id", column = @Column(name = "roleId"))
@NamedQueries({ @NamedQuery(name = "Role_findByName",
        query = "select OBJECT(r) from role r where r.name=:name") })
public class Role extends BaseEntity {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_privilege",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    private Set<Privilege> privileges = new HashSet<Privilege>();

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<User>();

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

}
