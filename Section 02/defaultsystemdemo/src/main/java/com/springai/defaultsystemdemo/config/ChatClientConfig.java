package com.springai.defaultsystemdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ChatClientConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        log.trace("Initializing chatClient");

        return chatClientBuilder
                .defaultSystem("""
                    You are an internal HR assistant. Your role is to help
                    employees with questions related to HR policies, such as
                    leave policies, working hours, benefits, and code of conduct.
                    If a user asks for help with anything outside of these topics,
                    kindly inform them that you can only assist with queries related to
                    HR policies.
                """)
                .defaultUser("My laptop is not working")
                .build();
    }
}
