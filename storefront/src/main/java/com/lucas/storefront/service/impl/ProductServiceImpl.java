package com.lucas.storefront.service.impl;

import com.lucas.storefront.dto.ProductDetailsDTO;
import com.lucas.storefront.dto.ProductInfoDTO;
import com.lucas.storefront.entity.ProductEntity;
import com.lucas.storefront.mapper.IProductMapper;
import com.lucas.storefront.repository.ProductRepository;
import com.lucas.storefront.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository repository;
    private final RestClient warehouseClient;
    private final IProductMapper mapper;

    @Override
    public ProductEntity save(final ProductEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void changeActivated(final UUID id, final boolean active) {
        var entity = findById(id);
        entity.setActive(active);
        repository.save(entity);
    }

    @Override
    public List<ProductEntity> findAllActive() {
        return repository.findByActiveTrueOrderByNameAsc();
    }

    @Override
    public ProductInfoDTO findInfo(final UUID id) {
        var entity = findById(id);
        var price = requestCurrentAmount(id);
        return mapper.toDTO(entity, price);
    }

    @Override
    public void purchase(final UUID id) {
        purchaseWarehouse(id);
    }

    private ProductEntity findById(final UUID id) {
        return repository.findById(id).orElseThrow();
    }

    private BigDecimal requestCurrentAmount(final UUID id) {
        var dto = warehouseClient.get()
                .uri("/products/" + id)
                .retrieve()
                .body(ProductDetailsDTO.class);

        return dto.price();
    }

    private void purchaseWarehouse(final UUID id) {
        var path = String.format("/products/%s/purchase", id);
        warehouseClient.post()
                .uri(path)
                .retrieve()
                .toBodilessEntity();
    }
}
