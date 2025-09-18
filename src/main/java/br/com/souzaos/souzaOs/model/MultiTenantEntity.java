package br.com.souzaos.souzaOs.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@MappedSuperclass
@FilterDef(name = "tenantFilter", parameters = @ParamDef(name = "tenantId", type = String.class))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class MultiTenantEntity {

    @Column(name = "tenant_id", nullable = false)
    private String tenantId;

}
