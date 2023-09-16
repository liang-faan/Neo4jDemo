package com.lfa.neo4j.harness.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.net.URI;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class AppConfig implements WebFluxConfigurer {

    @Bean
    public RouterFunction<ServerResponse> staticContentResponse() {
        return RouterFunctions.resources("/browser/**", new ClassPathResource("static/"));
    }

    @Bean
    public RouterFunction<ServerResponse> homeContentResponse() {
        return route(GET("/browser"), request ->
                ServerResponse.temporaryRedirect(URI.create("/browser/index.html")).build());
    }

    @Bean
    public RouterFunction<ServerResponse> home2ContentResponse() {
        return route(GET("/browser/"), request ->
                ServerResponse.temporaryRedirect(URI.create("/browser/index.html")).build());
    }

    @Bean
    public RouterFunction<ServerResponse> rootContentResponse() {
        return route(GET("/"), request ->
                ServerResponse.temporaryRedirect(URI.create("/browser/index.html")).build());
    }

}
