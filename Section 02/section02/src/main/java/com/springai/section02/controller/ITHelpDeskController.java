package com.springai.section02.controller;

import com.springai.section02.service.ITHelpDeskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@Slf4j
@RequiredArgsConstructor
public class ITHelpDeskController {

    private final ITHelpDeskService ITHelpDeskService;

    @GetMapping("/ask/it-help-desk")
    public ResponseEntity<String> askQuery(@RequestParam("query") String query) {
        log.trace("ITHelpDeskController::askQuery() execution started...");
        String response = ITHelpDeskService.askQuery(query);
        log.trace("ITHelpDeskController::askQuery() execution ended...");

        return ResponseEntity.ok(response);
    }
}
