package com.ankush.springbootdemo.handler;

import com.ankush.springbootdemo.model.PingResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class AdminHandler {
    public Mono<ServerResponse> ping(ServerRequest request) {
        System.out.println("HELLLOOOO");
//        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
//                .body(new PingResponse("PONG!!"),PingResponse.class);
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Hello, Spring!"));
    }
}