package com.dgarg20.java_base.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Deepanshu Garg on 29/11/20.
 */
public class BaseEntity implements Serializable {

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_At")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
