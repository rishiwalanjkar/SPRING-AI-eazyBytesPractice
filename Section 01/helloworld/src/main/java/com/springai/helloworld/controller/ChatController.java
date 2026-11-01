package com.springai.helloworld.controller;

import com.springai.helloworld.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    @GetMapping
    public ResponseEntity<String> getLLMResponse(@RequestParam String message) {
        log.trace("getLLMResponse() started..");
        String response = chatService.getLLMResponse(message);
        log.trace("getLLMResponse() endeded..");
        return ResponseEntity.ok(response);
    }
}
