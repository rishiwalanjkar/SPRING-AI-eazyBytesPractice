package com.springai.prompttemplate.service.impl;

import com.springai.prompttemplate.service.CustomerAssistantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerAssistantServiceImpl implements CustomerAssistantService {

    private final ChatClient chatClient;

    @Value("classpath:/templates/prompts/AskSupport.st")
    private Resource askSupportTemplate;

    @Override
    public String askSupport(String customerName, String customerMessage) {
        log.trace("CustomerAssistantServiceImpl::askSupport() execution started...");
        String response = chatClient
                .prompt()
                .user(askSupportSpec -> askSupportSpec.text(askSupportTemplate).param("customerName", customerName).param("customerMessage", customerMessage))
                .call()
                .content();

        log.trace("CustomerAssistantServiceImpl::askSupport() execution ended...");

        return response;
    }
}
