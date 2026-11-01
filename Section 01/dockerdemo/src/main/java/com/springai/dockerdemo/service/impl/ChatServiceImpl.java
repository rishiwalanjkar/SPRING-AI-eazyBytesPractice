package com.springai.dockerdemo.service.impl;

import com.springai.dockerdemo.service.ChatService;
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
    public String askLLM(String message) {
        log.trace("ChatServiceImpl::askLLM() execution started..");
        String response = chatClient.prompt(message).call().content();
        log.trace("ChatServiceImpl::askLLM() execution ended..");
        return response;
    }
}
