package com.springai.prompttemplate.controller;

import com.springai.prompttemplate.service.CustomerAssistantService;
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
@RequestMapping("/customer/support")
public class CustomerAssistantController {

    private final CustomerAssistantService customerAssistantService;

    @GetMapping("/ask")
    public ResponseEntity<String> askSupport(@RequestParam String customerName, @RequestParam String customerMessage) {
        log.trace("CustomerAssistantController::askCustomerSupport() execution started...");
        String response = customerAssistantService.askSupport(customerName, customerMessage);
        log.trace("CustomerAssistantController::askCustomerSupport() execution ended...");

        return ResponseEntity.ok(response);
    }
}
