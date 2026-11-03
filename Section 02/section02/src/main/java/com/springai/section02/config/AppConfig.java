package com.springai.section02.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ChatClient createChatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.build();
    }
}
