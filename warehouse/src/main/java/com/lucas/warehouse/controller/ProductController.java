package com.lucas.warehouse.controller;

import com.lucas.warehouse.controller.request.ProductSaveRequest;
import com.lucas.warehouse.controller.response.ProductDetailResponse;
import com.lucas.warehouse.controller.response.ProductSavedResponse;
import com.lucas.warehouse.mapper.IProductMapper;
import com.lucas.warehouse.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {

    private final IProductService service;
    private final IProductMapper mapper;

    @PostMapping
    @ResponseStatus(CREATED)
    ProductSavedResponse create(@RequestBody final ProductSaveRequest request){
        var entity = mapper.toEntity(request);
        entity = service.save(entity);
        return mapper.toSavedResponse(entity);
    }

    @PostMapping("{id}/purchase")
    @ResponseStatus(NO_CONTENT)
    void purchase(@PathVariable final UUID id){
        service.purchase(id);
    }

    @GetMapping("{id}")
    ProductDetailResponse findById(@PathVariable final UUID id){
        var dto = service.findById(id);
        return mapper.toDetailResponse(dto);
    }
}
