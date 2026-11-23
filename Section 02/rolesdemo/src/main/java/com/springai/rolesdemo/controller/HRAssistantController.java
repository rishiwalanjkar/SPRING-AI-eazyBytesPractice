package com.springai.rolesdemo.controller;

import com.springai.rolesdemo.service.HRService;
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

    private final HRService hrService;

    @GetMapping("/ask")
    public ResponseEntity<String> askHR(@RequestParam String question) {
        log.trace("HRAssistantController::askHR() execution started");
        String reply = hrService.askHR(question);
        log.trace("HRAssistantController::askHR() execution started");

        return ResponseEntity.ok(reply);
    }
}
