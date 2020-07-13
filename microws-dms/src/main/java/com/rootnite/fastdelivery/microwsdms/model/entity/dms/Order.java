package com.rootnite.fastdelivery.microwsdms.model.entity.dms;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = "dms", name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "client_id")
    private long clientId;
    @Column(name = "commerce_id")
    private long commerceId;
    @Column(name = "driver_id")
    private long driverId;
    @Column(name = "products_cost")
    private BigDecimal productsCost;
    @Column(name = "delivery_cost")
    private BigDecimal deliveryCost;
    @Column(name = "delivery_time_range")
    private String deliveryTimeRange;
    @Column(name = "order_state")
    private Integer orderState;
    @Column(name = "request_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;
    @Column(name = "preparation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date preparationDate;
    @Column(name = "delivery_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;
    @Column(name = "reception_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receptionDate;
    @Column(name = "address")
    private String address;
    @Column(name = "reference")
    private String reference;
    @Column(name = "nit")
    private String nit;
    @Column(name = "business_name")
    private String businessName;
    @Column(name = "total")
    private BigDecimal total;
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
