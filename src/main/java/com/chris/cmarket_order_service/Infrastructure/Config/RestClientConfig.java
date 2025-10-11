package com.chris.cmarket_order_service.Infrastructure.Config;

import com.chris.cmarket_order_service.Common.Client.CmarketAuthClient;
import com.chris.cmarket_order_service.Common.Interceptor.RestClientLoggingInterceptor;
import com.chris.cmarket_order_service.Product.Client.CmarketProductClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

    @Bean
    public CmarketProductClient productClient(HttpServiceProxyFactory factory) {
        return factory.createClient(CmarketProductClient.class);
    }

    @Bean
    public CmarketAuthClient authClient(HttpServiceProxyFactory factory) {
        return factory.createClient(CmarketAuthClient.class);
    }

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .requestInterceptor(new RestClientLoggingInterceptor())
                .build();
    }

    @Bean
    public HttpServiceProxyFactory httpServiceProxyFactory(RestClient restClient) {
        return HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
                .build();
    }
}
