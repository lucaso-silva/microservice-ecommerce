package com.lucas.storefront.mapper;

import com.lucas.storefront.controller.request.ProductSaveRequest;
import com.lucas.storefront.controller.response.ProductAvailableResponse;
import com.lucas.storefront.controller.response.ProductDetailsResponse;
import com.lucas.storefront.controller.response.ProductSavedResponse;
import com.lucas.storefront.dto.ProductInfoDTO;
import com.lucas.storefront.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IProductMapper {

    ProductInfoDTO toDTO(final ProductEntity entity, final BigDecimal price);

    @Mapping(target = "active", constant = "false")
    ProductEntity toEntity(final ProductSaveRequest request);

    ProductSavedResponse toResponse(final ProductEntity entity);

    List<ProductAvailableResponse> toResponse(final List<ProductEntity> entities);

    ProductDetailsResponse toResponse(final ProductInfoDTO dto);

}
