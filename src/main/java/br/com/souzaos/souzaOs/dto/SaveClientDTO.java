package br.com.souzaos.souzaOs.dto;

import br.com.souzaos.souzaOs.model.WorkOrder;

public record SaveClientDTO (String name, String phoneNumber, WorkOrder workOrder) {
}
