package com.project.rest.config;

import com.project.rest.controller.Impl.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@CrossOrigin(origins = {"http://localhost:3000"})
public class WebSocketConfiguration implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(getChatWebSocketHandler(), "/chat")
                .setAllowedOriginPatterns("*");
    }

    @Bean
    public WebSocketHandler getChatWebSocketHandler(){
        return new ChatServiceImpl();}
}
