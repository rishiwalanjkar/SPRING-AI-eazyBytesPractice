package com.springai.helloworld.service.impl;

import com.springai.helloworld.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatClient chatClient;

    @Override
    public String getLLMResponse(String message) {
        return chatClient.prompt(message).call().content();
    }
}
