package com.lucas.warehouse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucas.warehouse.entity.StockStatus;

import java.util.UUID;

public record StockStatusMessage(
        @JsonProperty("id")
        UUID id,
        @JsonProperty("status")
        StockStatus status
) {
}
