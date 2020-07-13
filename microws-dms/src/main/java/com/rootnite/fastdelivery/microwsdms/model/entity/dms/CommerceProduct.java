package com.rootnite.fastdelivery.microwsdms.model.entity.dms;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = "dms", name = "commerce_product")
public class CommerceProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "commerce_id", nullable = false)
    private long commerceId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "image")
    private byte[] image;
    @Column(name = "price")
    private String price;
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
