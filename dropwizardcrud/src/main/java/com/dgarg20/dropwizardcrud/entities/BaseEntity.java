package com.dgarg20.dropwizardcrud.entities;


import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Date;

public class BaseEntity implements Serializable {
    @Column(name = "created_at")
    protected Date createdAt = new Date(System.currentTimeMillis());

    @Column(name = "updated_at")
    protected Date updatedAt = new Date(System.currentTimeMillis());
}
