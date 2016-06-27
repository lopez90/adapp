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
    private String privilege;

}
