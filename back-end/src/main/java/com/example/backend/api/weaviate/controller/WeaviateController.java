package com.example.backend.api.weaviate.controller;

import com.example.backend.api.weaviate.service.WeaviateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/weaviate")
public class WeaviateController {

    private final WeaviateService  weaviateService;

    public WeaviateController(WeaviateService weaviateService) {
        this.weaviateService = weaviateService;
    }

    @GetMapping("/ready")
    public boolean checkWeaviateIsReady(){
        return weaviateService.isWeaviateReady();
    }


}
