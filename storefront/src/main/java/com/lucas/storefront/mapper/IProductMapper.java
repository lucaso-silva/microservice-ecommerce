package com.lucas.storefront.mapper;

import com.lucas.storefront.dto.ProductInfoDTO;
import com.lucas.storefront.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.math.BigDecimal;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IProductMapper {

    ProductInfoDTO toDTO(final ProductEntity entity, final BigDecimal price);

}
