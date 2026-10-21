package com.springai.helloworld.controller;

import com.springai.helloworld.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/{message}")
    public ResponseEntity<String> getLLMResponse(@PathVariable String message) {
        log.trace("getLLMResponse() started..");
        String response = chatService.getLLMResponse(message);
        log.trace("getLLMResponse() endeded..");
        return ResponseEntity.ok(response);
    }
}
