package com.example.gateway_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }


    // RouteLocator : özelleştirilmiş yönlendirme url oluşturmak için kullanılır
    // mesela http://localhost:8081/orhanturkmenoglu/api/loans/create
    // kendi ismimizi vb özelleştirmeler yapabiliriz.
    /**
     *  .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())) :
     *   yanıt başlığına  tarih ve saat bilgisi ekler
     *   bu tarz filterler de kullanabiliriz
     * */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/custom/accounts/api/**")
                        .filters(f -> f.rewritePath("/custom/accounts/api/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://ACCOUNTS"))
                .route(r -> r.path("/custom/loans/api/**")
                        .filters(f -> f.rewritePath("/custom/loans/api/(?<segment>.*)", "/${segment}")
                        .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://LOANS"))
                .route(r -> r.path("/custom/cards/api/**")
                        .filters(f -> f.rewritePath("/custom/cards/api/(?<segment>.*)", "/${segment}")
                        .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://CARDS"))
                .build();
    }
}
