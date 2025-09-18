package br.com.souzaos.souzaOs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Filter;


import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Filter(name = "tenantFilter", condition = "tenant_id = :tenantId")
public class WorkOrder extends MultiTenantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String device;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "order_status")
    private OrderStatus orderStatus;

    @CreationTimestamp
    @Column(name = "pickup_date", updatable = false)
    private Timestamp pickupDate;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
