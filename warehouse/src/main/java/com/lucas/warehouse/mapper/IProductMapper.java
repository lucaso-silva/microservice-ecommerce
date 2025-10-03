package com.lucas.warehouse.mapper;

import com.lucas.warehouse.controller.request.ProductSaveRequest;
import com.lucas.warehouse.controller.response.ProductDetailResponse;
import com.lucas.warehouse.controller.response.ProductSavedResponse;
import com.lucas.warehouse.dto.ProductStorefrontSaveDTO;
import com.lucas.warehouse.entity.ProductEntity;
import com.lucas.warehouse.entity.StockEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.util.Set;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public abstract class IProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "stocks", ignore = true)
    public abstract ProductEntity toEntity(final ProductSaveRequest request);

    public abstract ProductSavedResponse toSavedResponse(final ProductEntity entity);

    public abstract ProductStorefrontSaveDTO toDTO(final ProductEntity entity);

    @Mapping(target = "price", expression = "java(getCurrentPrice(entity.getStocks())")
    public abstract ProductDetailResponse toDetailResponse(final ProductEntity entity);

}
