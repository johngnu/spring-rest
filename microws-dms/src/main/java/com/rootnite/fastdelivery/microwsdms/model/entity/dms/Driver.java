package com.rootnite.fastdelivery.microwsdms.model.entity.dms;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = "dms", name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "complete_name")
    private String completeName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "city")
    private Integer city;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "document")
    private String document;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @PrePersist
    void prePersist() {
        this.createdBy = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        this.createdDate = new Date();
    }

    @PreUpdate
    void preUpdate() {
        this.createdBy = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        this.createdDate = new Date();
    }

}
