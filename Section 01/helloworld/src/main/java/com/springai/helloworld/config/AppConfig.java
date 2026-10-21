package com.springai.helloworld.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Bean
    public ChatClient createChatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.build();
    }
}
