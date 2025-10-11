package com.chris.cmarket_order_service.Auth.Property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPublicKey;

@Component
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperties {
    /**
     * Public key location of JWT key
     */
    private RSAPublicKey publicKey;
}
