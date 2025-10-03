package com.lucas.warehouse.service.impl;

import com.lucas.warehouse.dto.StockStatusMessage;
import com.lucas.warehouse.service.IProductChangeAvailabilityProducer;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProductChangeAvailabilityProducerImpl implements IProductChangeAvailabilityProducer {

    private final RabbitTemplate rabbitTemplate;
    private final String exchangeName;
    private final String routingKeyName;

    public ProductChangeAvailabilityProducerImpl(final RabbitTemplate rabbitTemplate,
                                                 @Value("${spring.rabbitmq.exchange.product-change-availability}")
                                                 final String exchangeName,
                                                 @Value("${spring.rabbitmq.routing-key.product-change-availability}")
                                                 final String routingKeyName) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchangeName = exchangeName;
        this.routingKeyName = routingKeyName;
    }

    @Override
    public void notifyStatusChange(final StockStatusMessage message) {
        rabbitTemplate.convertAndSend(exchangeName, routingKeyName, message);
    }
}
