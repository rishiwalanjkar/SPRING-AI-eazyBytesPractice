package com.springai.ollama.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfig {

    @Bean
    public ChatClient createChatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.build();
    }
}
