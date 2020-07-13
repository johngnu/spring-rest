package com.rootnite.fastdelivery.microwsdms.model.entity.dms;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = "dms", name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "complete_name")
    private String completeName;
    @Column(name = "auth_type")
    private Integer authType;
    @Column(name = "auth_id")
    private Long authId;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "nit")
    private String nit;
    @Column(name = "business_name")
    private String businessName;
    @Column(name = "enabled")
    private Boolean enabled;
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
        this.enabled = true;
    }

    @PreUpdate
    void preUpdate() {
        this.createdBy = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        this.createdDate = new Date();
    }
}
