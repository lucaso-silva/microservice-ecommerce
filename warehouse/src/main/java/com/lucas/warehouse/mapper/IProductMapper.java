package com.lucas.warehouse.mapper;

import com.lucas.warehouse.controller.request.ProductSaveRequest;
import com.lucas.warehouse.controller.response.ProductDetailResponse;
import com.lucas.warehouse.controller.response.ProductSavedResponse;
import com.lucas.warehouse.dto.ProductStorefrontSaveDTO;
import com.lucas.warehouse.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "stocks", ignore = true)
//    @Mapping(target = "price", ignore = true)
    ProductEntity toEntity(final ProductSaveRequest request);

    ProductSavedResponse toSavedResponse(final ProductEntity entity);

    ProductStorefrontSaveDTO toDTO(final ProductEntity entity);

    ProductDetailResponse toDetailResponse(final ProductEntity entity);

}
