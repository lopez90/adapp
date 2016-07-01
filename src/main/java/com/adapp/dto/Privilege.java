package com.adapp.dto;

import javax.persistence.*;
import java.util.HashSet;

import java.util.Set;

/**
 * Created by Dom on 27.06.2016.
 */
@Entity
@Table
@AttributeOverride(name = "id", column = @Column(name = "privilegeId"))
public class Privilege extends BaseEntity {

    @ManyToMany(mappedBy = "privileges")
    private Set<Role> roles = new HashSet<Role>();

    @Column(name = "name",unique = true)
    private String name;

}
