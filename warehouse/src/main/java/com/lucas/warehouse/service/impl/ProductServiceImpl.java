package com.lucas.warehouse.service.impl;

import com.lucas.warehouse.dto.ProductStorefrontSaveDTO;
import com.lucas.warehouse.entity.ProductEntity;
import com.lucas.warehouse.mapper.IProductMapper;
import com.lucas.warehouse.repository.ProductRepository;
import com.lucas.warehouse.service.IProductService;
import com.lucas.warehouse.service.IStockService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements IProductService {

    private final ProductRepository repository;
    private final IStockService stockService;
    private final RestClient storefrontClient;
    private final IProductMapper mapper;

    @Override
    public ProductEntity save(ProductEntity entity) {
        repository.save(entity);
        var dto = mapper.toDTO(entity);
        saveStorefront(dto);
        return null;
    }

    @Override
    public ProductEntity findById(UUID id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void purchase(UUID ui) {
        var entity = findById(ui);
        var stock = entity.decStock();
        repository.save(entity);
        if(stock.isUnavailable()){
            stockService.changeStatus(entity.getId(), stock.getStatus());
        }
    }

    private void saveStorefront(final ProductStorefrontSaveDTO dto) {
        storefrontClient.post()
                .uri("/products")
                .body(dto)
                .retrieve()
                .body(ProductStorefrontSaveDTO.class);
    }
}
