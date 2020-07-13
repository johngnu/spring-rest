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
@Table(schema = "dms", name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "order_id")
    private long orderId;
    @Column(name = "commerce_product_id")
    private long commerceProductId;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "product_cost")
    private BigDecimal productCost;
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "clarification")
    private String clarification;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @PrePersist
    void prePersist() {
        this.createdBy = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        this.createdDate = new Date();
    }

}
