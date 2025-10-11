package com.chris.cmarket_order_service.User.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    Long id;

    String uuid;

    @NotBlank
    private String name;
}
