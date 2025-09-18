package br.com.souzaos.souzaOs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Filter;


import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Filter(name = "tenantFilter", condition = "tenant_id = :tenantId")
public class Client extends MultiTenantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Pattern(
        regexp = "\\(\\d{2}\\) \\d{8,9}",
        message = "O número de telefone deve estar no formato (XX) XXXXXXXXX"
    )
    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkOrder> workOrders;
}
