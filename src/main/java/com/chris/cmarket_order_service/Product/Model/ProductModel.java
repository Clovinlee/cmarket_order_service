package com.chris.cmarket_order_service.Product.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private String slug;
    private String description;
    private Integer quantity;

    @Column(name = "rarity_id", updatable = false, insertable = false)
    private Long rarityId;

    @Positive
    private BigDecimal price;
}