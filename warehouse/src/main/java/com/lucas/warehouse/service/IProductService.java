package com.lucas.warehouse.service;

import com.lucas.warehouse.entity.ProductEntity;

import java.util.UUID;

public interface IProductService {

    ProductEntity save(final ProductEntity entity);

    ProductEntity findById(final UUID id);

    void purchase(final UUID ui);
}
