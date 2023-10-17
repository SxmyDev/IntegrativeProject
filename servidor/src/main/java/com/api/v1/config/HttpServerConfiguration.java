package com.api.v1.config;

import reactor.netty.http.server.HttpServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpServerConfiguration {

    @Bean
    public HttpServer httpServer() {
        return HttpServer.create().host("0.0.0.0").port(8080);
    }
}
