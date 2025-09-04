package br.com.souzaos.souzaOs.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "WorkOrders")
@Getter
@Setter
public class WorkOrder {

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

    // RELACIONAMENTO COM CLIENT
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client; // singular para bater com mappedBy
}
