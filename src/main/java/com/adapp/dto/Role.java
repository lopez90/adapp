package com.adapp.dto;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Dom on 27.06.2016.
 */
@Entity
@Table
@AttributeOverride(name = "id", column = @Column(name = "roleId"))
public class Role extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "privilegeId"))
    private Set<Privilege> privileges;
}
