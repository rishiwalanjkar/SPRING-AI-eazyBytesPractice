package com.springai.defaultsystemdemo.controller;

import com.springai.defaultsystemdemo.service.HRAssistantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/hr")
public class HRAssistantController {

    private final HRAssistantService hrAssistantService;

    @GetMapping("/ask")
    public ResponseEntity<String> askHR(@RequestParam(required = false) String question) {
        log.trace("HRAssistantController::askHR() execution started...");
        String answer = hrAssistantService.askHR(question);
        log.trace("HRAssistantController::askHR() execution ended...");

        return ResponseEntity.ok(answer);
    }
}
