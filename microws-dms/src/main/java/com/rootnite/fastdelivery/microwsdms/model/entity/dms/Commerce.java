package com.rootnite.fastdelivery.microwsdms.model.entity.dms;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = "dms", name = "commerce")
public class Commerce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "denomination")
    private String denomination;
    @Column(name = "nit")
    private String nit;
    @Column(name = "address")
    private String address;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "city")
    private Integer city;
    @Column(name = "logo")
    private byte[] logo;
    @Column(name = "background")
    private byte[] background;
    @Column(name = "commission")
    private Double commission;
    @Column(name = "commerce_category")
    private Integer commerceCategory;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "time_range_attention")
    private String timeRangeAttention;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
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
