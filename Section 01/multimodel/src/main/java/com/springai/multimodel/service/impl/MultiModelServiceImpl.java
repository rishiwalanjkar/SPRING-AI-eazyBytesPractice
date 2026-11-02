package com.springai.multimodel.service.impl;

import com.springai.multimodel.service.MultiModelService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MultiModelServiceImpl implements MultiModelService {

    @Resource
    private ChatClient openAIChatClient;

    @Resource
    private ChatClient ollamaChatClient;

    @Override
    public String askGPT(String message) {
        log.trace("MultiModelServiceImpl::askGPT() execution started...");
        String response = openAIChatClient.prompt(message).call().content();
        log.trace("MultiModelServiceImpl::askGPT() execution started...");
        return response;
    }

    @Override
    public String askOllama(String message) {
        log.trace("MultiModelServiceImpl::askOllama() execution started...");
        String response = ollamaChatClient.prompt(message).call().content();
        log.trace("MultiModelServiceImpl::askOllama() execution started...");
        return response;
    }
}
