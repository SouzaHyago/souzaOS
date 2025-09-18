package br.com.souzaos.souzaOs.dto;

import br.com.souzaos.souzaOs.model.WorkOrder;

import java.sql.Timestamp;
import java.util.List;

public record ResponseClientDTO(String name, String phoneNumber, String tenantId, Timestamp createdAt, List<WorkOrder> workOrders) {
}
