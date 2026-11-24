package com.springai.dockerdemo.controller;

import com.springai.dockerdemo.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
@RestController
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/chat")
    public ResponseEntity<String> askLLM(@RequestParam("message") String message) {
        log.trace("ChatController::askLLM() execution started...");
        String response = chatService.askLLM(message);
        log.trace("ChatController::askLLM() execution ended...");
        return ResponseEntity.ok(response);
    }
}
