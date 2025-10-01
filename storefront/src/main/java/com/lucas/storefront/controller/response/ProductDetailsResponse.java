package com.lucas.storefront.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.core.util.Json;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDetailsResponse(
        @JsonProperty("id")
        UUID id,
        @JsonProperty("name")
        String name,
        @JsonProperty("price")
        BigDecimal price
) {
}
