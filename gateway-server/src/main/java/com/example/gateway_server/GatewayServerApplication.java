package com.example.gateway_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }


    @Bean
    public RouteLocator  customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("accounts", r -> r.path("/bankapp/accounts/**")
                        .filters(f -> f.rewritePath("/bankapp/accounts/(?<segment>.*)","/${segment}")
                                .circuitBreaker(c->c.setName("accountsCircuitBreaker")
                                        .setFallbackUri("forward:/contactSupport")))
                        .uri("lb://ACCOUNTS"))
                .route("loans", r -> r.path("/bankapp/loans/**")
                        .filters(f -> f.rewritePath("/bankapp/loans/(?<segment>.*)","/${segment}"))
                        .uri("lb://LOANS"))

                .route("cards", r -> r.path("/bankapp/cards/**")
                        .filters(f -> f.rewritePath("/bankapp/cards/(?<segment>.*)","/${segment}"))
                        .uri("lb://CARDS"))
                .build();
    }
}
