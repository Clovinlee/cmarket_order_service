package com.chris.cmarket_order_service.Product.Client;

import com.chris.cmarket_order_service.Common.Response.APIResponse;
import com.chris.cmarket_order_service.Product.Dto.ProductDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

public interface CmarketProductClient {
    @GetExchange(
            value = "${cmarket.base-url}/products/{slug}",
            accept = "application/json"
    )
    APIResponse<ProductDTO> fetchProductData(@PathVariable String slug);
}
