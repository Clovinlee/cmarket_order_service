package com.chris.cmarket_order_service.Common.Client;

import com.chris.cmarket_order_service.Common.Response.APIResponse;
import com.chris.cmarket_order_service.User.Dto.UserDTO;
import org.springframework.web.service.annotation.PostExchange;

public interface CmarketAuthClient {
    @PostExchange(
            value = "${cmarket.base-url}/user/me",
            contentType = "application/json",
            accept = "application/json"
    )
    APIResponse<UserDTO> fetchUserData();
}
