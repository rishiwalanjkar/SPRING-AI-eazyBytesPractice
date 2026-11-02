package com.springai.multimodel.controller;

import com.springai.multimodel.service.MultiModelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@Slf4j
@RequiredArgsConstructor
public class MultiModelController {

    private final MultiModelService multiModelService;

    @GetMapping("/openai/chat")
    public ResponseEntity<String> askGPT(@RequestParam("message") String message) {
        log.trace("MultiModelController::askGPT() execution started...");
        String response = multiModelService.askGPT(message);
        log.trace("MultiModelController::askGPT() execution ended...");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ollama/chat")
    public ResponseEntity<String> askOllama(@RequestParam("message") String message) {
        log.trace("MultiModelController::askOllama() execution started...");
        String response = multiModelService.askOllama(message);
        log.trace("MultiModelController::askOllama() execution ended...");
        return ResponseEntity.ok(response);
    }
 }
