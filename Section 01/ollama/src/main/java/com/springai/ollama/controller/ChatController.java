package com.springai.ollama.controller;

import com.springai.ollama.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    @GetMapping
    public ResponseEntity<String> askLLM(@RequestParam String message) {
        log.trace("askLLM execution started...");
        String response = chatService.askLLM(message);
        log.trace("askLLM execution ended...");
        return ResponseEntity.ok(response);
    }
}
