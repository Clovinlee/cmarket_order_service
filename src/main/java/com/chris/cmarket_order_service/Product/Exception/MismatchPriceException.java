package com.chris.cmarket_order_service.Product.Exception;

import java.io.Serial;

public class MismatchPriceException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public MismatchPriceException(String errorMessage, Throwable err) {
        super(errorMessage, err);
        String messageKey = "error.mismatch_price"; // Default message key
    }

    public MismatchPriceException(String errorMessage) {
        this(errorMessage, null);
    }

    public MismatchPriceException() {
        this("The product price is invalid, please try again.", null);
    }
}
