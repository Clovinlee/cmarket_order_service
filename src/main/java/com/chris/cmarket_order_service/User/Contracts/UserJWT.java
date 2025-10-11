package com.chris.cmarket_order_service.User.Contracts;

public interface UserJWT {
    /**
     * @return user auth DB id
     */
     Long getId();

    /**
     * @return user auth UUID
     */
     String getUuid();

    /**
     * @return user auth name
     */
     String getName();
}
