package com.lucas.warehouse.service;

import com.lucas.warehouse.dto.StockStatusMessage;

public interface IProductChangeAvailabilityProducer {

    void notifyStatusChange(final StockStatusMessage message);
}
