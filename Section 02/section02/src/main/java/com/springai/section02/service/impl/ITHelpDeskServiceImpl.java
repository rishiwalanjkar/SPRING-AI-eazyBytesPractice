package com.springai.section02.service.impl;

import com.springai.section02.service.ITHelpDeskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ITHelpDeskServiceImpl implements ITHelpDeskService {

    private final ChatClient chatClient;

    @Override
    public String askQuery(String query) {
        log.trace("ITHelpDeskServiceImpl::askQuery() execution started...");
        String response =  chatClient
                                .prompt()
                                .system("""
                                        You are an internal IT helpdesk assistant. Your role is to assist
                                        employees with IT-related issues such as resetting passwords, 
                                        unlocking accounts, and answering query related to IT policies.
                                        If user requests help with anything outside of these
                                        responsibilities, respond politely and inform then that you are 
                                        only able to assist with IT support tasks within you defined scope.
                                        """)
                                .user(query)
                                .call()
                                .content();
        log.trace("ITHelpDeskServiceImpl::askQuery() execution started...");

        return response;
    }
}
