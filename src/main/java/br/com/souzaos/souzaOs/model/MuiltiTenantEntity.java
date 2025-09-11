package br.com.souzaos.souzaOs.model;

import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@FilterDef(name = "tenantFilter", parameters = @ParamDef(name = "tenantId", type = String.class))
public abstract class MuiltiTenantEntity {
}
