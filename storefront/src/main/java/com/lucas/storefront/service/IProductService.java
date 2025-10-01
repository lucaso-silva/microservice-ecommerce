package com.lucas.storefront.service;

import com.lucas.storefront.dto.ProductInfoDTO;
import com.lucas.storefront.entity.ProductEntity;

import java.util.List;
import java.util.UUID;

public interface IProductService {

    ProductEntity save(final ProductEntity entity);

    void changeActivated(final UUID id, final boolean activate);

    List<ProductEntity> findAllActive();

    ProductInfoDTO findInfo(final UUID id);

    void purchase(final UUID id);
}
