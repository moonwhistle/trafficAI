package com.example.backend.api.weaviate.controller;

import com.example.backend.api.weaviate.service.DataTransferService;
import com.example.backend.api.weaviate.service.TestService;
import com.example.backend.api.weaviate.service.WeaviateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api/weaviate")
public class WeaviateController {

    private final WeaviateService weaviateService;
    private final DataTransferService dataTransferService;
    private final TestService testService;

    public WeaviateController(WeaviateService weaviateService, DataTransferService dataTransferService, TestService testService) {
        this.weaviateService = weaviateService;
        this.dataTransferService = dataTransferService;
        this.testService = testService;
    }

    @GetMapping("/ready")
    public boolean checkWeaviateIsReady() {
        return weaviateService.isWeaviateReady();
    }

    @PostMapping("/create-schemas")
    public ResponseEntity<String> createAllSchemas() {
        weaviateService.createAllSchemas();
        return ResponseEntity.ok("All schemas created successfully");
    }
    @PostMapping("/transfer-data")
    public ResponseEntity<String> transferDummyData() {
        dataTransferService.transferAddressDataToWeaviate();
        return ResponseEntity.ok("success");
    }

    @PostMapping("/EstimatedSales")
    public ResponseEntity<String> transferEstimatedSalesData(){
        dataTransferService.transferEstimatedSalesToWeaviate();
        return ResponseEntity.ok("EstimatedSales transfer successfully");
    }

    @PostMapping("/population")
    public ResponseEntity<String> transferPopulationData(){
        dataTransferService.transferPopulationDataToWeaviate();
        return ResponseEntity.ok("PopulationData transfer successfully");
    }

    @PostMapping("/commercial")
    public ResponseEntity<String> transferExpenditureCommercialData(){
        dataTransferService.transferExpenditureCommercialDistrictDataToWeaviate();
        return ResponseEntity.ok("Commercial Data transfer successfully");
    }

    @PostMapping("/officetel")
    public ResponseEntity<String> transferOfficetelValuationData(){
        dataTransferService.transferOfficetelValuationDataToWeaviate();
        return ResponseEntity.ok("Officetel Data transfer successfully");
    }

    @PostMapping("/store")
    public ResponseEntity<String> transferStoreData(){
        dataTransferService.transferStoreDataToWeaviate();
        return ResponseEntity.ok("Store Data transfer successfully");
    }

    @PostMapping("/passenger")
    public ResponseEntity<String> transferPassengerData(){
        dataTransferService.transferPassengerDataToWeaviate();
        return ResponseEntity.ok("Passenger Data transfer successfully");
    }

    @DeleteMapping("/delete-schema")
    public String deletePassengerSchema() {
        try {
            testService.delete();
            return "클래스 삭제 성공";
        } catch (Exception e) {
            return " 클래스 삭제 실패: " + e.getMessage();
        }
    }
}
