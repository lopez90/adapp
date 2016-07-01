package com.adapp.dto;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dom on 22.06.2016.
 */
@Entity
@Table
@AttributeOverride(name = "id", column = @Column(name = "userId"))
@NamedQueries({ @NamedQuery(name = "User_findByEmail",
        query = "select OBJECT(u) from user u where u.email=:email") })
public class User extends BaseEntity {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    private Set<Role> roles = new HashSet<Role>();

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    String email;

    @Column(name = "enabled")
    boolean enabled;

    @Column(name = "tokenExpired")
    boolean tokenExpired;


}
