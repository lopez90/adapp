package com.adapp.dto;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Andrzej Olkiewicz on 2016-06-23.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
