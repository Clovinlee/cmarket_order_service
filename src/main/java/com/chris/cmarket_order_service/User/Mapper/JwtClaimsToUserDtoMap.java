package com.chris.cmarket_order_service.User.Mapper;

import com.chris.cmarket_order_service.User.Dto.UserDTO;

import java.util.Map;

public class JwtClaimsToUserDtoMap {
    public static UserDTO map(String uuid, Map<String, Object> claims) {
        Object idObj = claims.get("id");
        Object nameObj = claims.get("name");

        if (idObj == null || nameObj == null) {
            throw new IllegalArgumentException("Invalid JWT claims: 'id' or 'name' missing");
        }

        if (!(idObj instanceof Number) || !(nameObj instanceof String name)) {
            throw new IllegalArgumentException("Invalid JWT claims: 'id' must be Number, 'name' must be String");
        }

        Long id = ((Number) idObj).longValue();

        return new UserDTO(id, uuid, name);
    }
}
