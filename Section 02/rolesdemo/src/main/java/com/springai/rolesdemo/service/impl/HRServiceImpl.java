package com.springai.rolesdemo.service.impl;

import com.springai.rolesdemo.service.HRService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HRServiceImpl implements HRService {

    private final ChatClient chatClient;

    @Override
    public String askHR(String question) {
        return chatClient
                .prompt()
                .system("""
                        You are an internal HR policy assistant. Your role is to assist 
                        employees with HR related questions like kind of leaves, new employee onboarding process or signing off process and 
                        anything other HR policy related questions. If user question anything out side of these responsibilities, respond politely
                        and inform them that you are only able to assist with HR policy question within your defined scope
                        """)
                .user(question)
                .call()
                .content();
    }
}
