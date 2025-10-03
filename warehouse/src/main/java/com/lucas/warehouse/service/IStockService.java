package com.lucas.warehouse.service;

import com.lucas.warehouse.entity.StockEntity;
import com.lucas.warehouse.entity.StockStatus;

import java.util.UUID;

public interface IStockService {

    StockEntity save(final StockEntity entity);

    void release(final UUID id);

    void inactivate(final UUID id);

    void changeStatus(final UUID id, final StockStatus status);
}
