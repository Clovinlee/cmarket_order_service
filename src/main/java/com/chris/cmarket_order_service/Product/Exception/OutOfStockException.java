package com.chris.cmarket_order_service.Product.Exception;

import java.io.Serial;

public class OutOfStockException extends RuntimeException {
    
    @Serial
    private static final long serialVersionUID = 1L;

    public OutOfStockException(String errorMessage, Throwable err) {
        super(errorMessage, err);
        String messageKey = "error.out_of_stock"; // Default message key
    }

    public OutOfStockException(String errorMessage) {
        this(errorMessage, null);
    }

    public OutOfStockException() {
        this("The item is currently out of stock.", null);
    }
}
