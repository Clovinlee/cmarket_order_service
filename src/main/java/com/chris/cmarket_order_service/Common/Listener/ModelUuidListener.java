package com.chris.cmarket_order_service.Common.Listener;

import com.chris.cmarket_order_service.Common.Model.Contract.HasUuidModel;
import jakarta.persistence.PrePersist;

import java.util.UUID;

/**
 * The obejct need to implement HasUuidModel interface
 */
public class ModelUuidListener {
    @PrePersist
    public void generateUuid(Object o) {
        if (o instanceof HasUuidModel model) {
            if (null != model.getUuid() && !model.getUuid().isEmpty()) return;

            model.setUuid(UUID.randomUUID().toString());
        }
    }
}
