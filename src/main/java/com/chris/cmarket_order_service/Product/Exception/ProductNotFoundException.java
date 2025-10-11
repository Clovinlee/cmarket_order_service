package com.chris.cmarket_order_service.Product.Exception;

import com.chris.cmarket_order_service.Common.Exception.NotFoundException;

public class ProductNotFoundException extends NotFoundException {

    public ProductNotFoundException(Long id) {
        super(String.format("Product with ID %s not found", id));
    }
    
}
