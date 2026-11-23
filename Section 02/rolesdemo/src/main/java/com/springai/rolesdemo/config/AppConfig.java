package com.springai.rolesdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class AppConfig {

    @Bean
    public ChatClient createChatClient(ChatClient.Builder chatClientBuilder) {
        log.trace("chatClient is initializing");

        return chatClientBuilder.build();
    }
}
