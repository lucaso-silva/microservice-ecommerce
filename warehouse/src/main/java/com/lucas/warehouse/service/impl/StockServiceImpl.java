package com.lucas.warehouse.service.impl;

import com.lucas.warehouse.dto.StockStatusMessage;
import com.lucas.warehouse.entity.StockEntity;
import com.lucas.warehouse.entity.StockStatus;
import com.lucas.warehouse.repository.ProductRepository;
import com.lucas.warehouse.repository.StockRepository;
import com.lucas.warehouse.service.IProductChangeAvailabilityProducer;
import com.lucas.warehouse.service.IProductService;
import com.lucas.warehouse.service.IStockService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.lucas.warehouse.entity.StockStatus.AVAILABLE;
import static com.lucas.warehouse.entity.StockStatus.UNAVAILABLE;

@Service
@AllArgsConstructor
public class StockServiceImpl implements IStockService {

    private final StockRepository repository;
//    private final IProductService productService;
    private final ProductRepository productRepository;
    private final IProductChangeAvailabilityProducer producer;

    @Override
    public StockEntity save(StockEntity entity) {
        var product = productRepository.findById(entity.getProduct().getId()).orElseThrow();
        entity.setProduct(product);
        return repository.save(entity);
    }

    @Override
    public void release(UUID id) {
        changeStatus(id, AVAILABLE);
    }

    @Override
    public void inactivate(UUID id) {
        changeStatus(id, UNAVAILABLE);
    }

    @Override
    public void changeStatus(UUID id, StockStatus status) {
        var entity = repository.findById(id).orElseThrow();
        entity.setStatus(status);
        repository.save(entity);
        producer.notifyStatusChange(new StockStatusMessage(entity.getProduct().getId(), status));
    }
}
