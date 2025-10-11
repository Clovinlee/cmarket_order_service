package com.chris.cmarket_order_service.Product.Dto;

import com.chris.cmarket_order_service.Product.Model.ProductModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@ToString
@NoArgsConstructor
@JsonInclude(Include.NON_ABSENT)
public class ProductDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String image;
    private String description;
    private BigDecimal price;
    private Integer quantity;

    @JsonProperty("rarity_id")
    private Long rarityId;

    public ProductDTO(ProductModel product) {
        this.id = product.getId();
        this.name = product.getName();
        this.image = product.getImage();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.rarityId = product.getRarityId();
        this.quantity = product.getQuantity();
    }
}