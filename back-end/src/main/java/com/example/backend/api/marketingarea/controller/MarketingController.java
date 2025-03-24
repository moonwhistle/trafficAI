package com.example.backend.api.marketingarea.controller;

import com.example.backend.api.marketingarea.service.MarketingRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MarketingController {

    private final MarketingRequestService marketingRequestService;

    @PostMapping("/expenditure-commercial-districts")
    public ResponseEntity<HttpStatus> saveExpenditureCommercialDistrict() {
        marketingRequestService.saveExpenditureCommercialDistrict();
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
