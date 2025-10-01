package com.lucas.storefront.service;

import com.lucas.storefront.dto.StockStatusMessage;

public interface IProductChangeAvailabilityConsumer {

    void receive(final StockStatusMessage message);

}
