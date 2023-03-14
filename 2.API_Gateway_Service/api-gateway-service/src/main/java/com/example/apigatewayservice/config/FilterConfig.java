package com.example.apigatewayservice.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {
    //@Bean
    public RouteLocator gatewayRoutes (RouteLocatorBuilder builder){
        return builder.routes()
                /// [first-service/**] 라우터 등록 -> 라우터가 완성이 되면 ->  uri("http://localhost:8081") 로 이동
                .route(r -> r.path("/first-service/**")
                        .filters(f -> f.addRequestHeader("first-request","first-request-header") //<key , value>
                                       .addResponseHeader("first-request","first-response-header"))
                        .uri("http://localhost:8081"))

                .route(r -> r.path("/second-service/**")
                        .filters(f -> f.addRequestHeader("second-request","second-request-header") //<key , value>
                                .addResponseHeader("second-request","second-response-header"))
                        .uri("http://localhost:8082"))
                .build();



    }
}
