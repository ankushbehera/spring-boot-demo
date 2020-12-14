package com.ankush.springbootdemo.router;

import com.ankush.springbootdemo.handler.AdminHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class AdminRouter {
    @Bean
    public RouterFunction<ServerResponse> route(AdminHandler pingHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/admin/v2/ping").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), pingHandler::ping);
                //.route(RequestPredicates.GET("/ping").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), pingHandler::ping);
    }
}
