package com.chris.cmarket_order_service.Auth.Config;

import com.chris.cmarket_order_service.Auth.Property.JwtProperties;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

@Configuration
@AllArgsConstructor
@PropertySource({
        "classpath:configs/jwt/jwt.properties"
})
public class JwtConfig {
    private final JwtProperties jwtProperties;

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(jwtProperties.getPublicKey()).build();
    }
}
