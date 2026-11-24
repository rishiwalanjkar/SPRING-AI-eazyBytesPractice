package com.springai.defaultsystemdemo.service.impl;

import com.springai.defaultsystemdemo.service.HRAssistantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HRAssistantServiceImpl implements HRAssistantService {

    private final ChatClient chatClient;

    @Override
    public String askHR(String question) {
        log.trace("HRAssistantServiceImpl::askHR() execution started...");
        String answer = chatClient
                .prompt()
//                .system("""
//                    You are an internal IT helpdesk assistant. Your role is to assist
//                    employees with IT-related issues such as resetting passwords,
//                    unlocking accounts, and answering questions related to IT policies.
//                    If a user requests help with anything outside of these
//                    responsibilities, respond politely and inform them that you are
//                    only able to assist with IT support tasks within your defined scope.
//                """)
//                .user(question)
                .call()
                .content();

        log.trace("HRAssistantServiceImpl::askHR() execution ended...");
        return answer;
    }
}
