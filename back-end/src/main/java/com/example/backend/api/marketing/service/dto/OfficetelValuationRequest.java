package com.example.backend.api.marketing.service.dto;


import com.example.backend.api.marketing.domain.OfficetelValuation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OfficetelValuationRequest(
        @JsonProperty("상가건물번호") String buildingNumber, // 상가 건물 번호(O)
        @JsonProperty("상가종류코드") String buildingType, // 상가 종류 코드
        @JsonProperty("고시일자") String announcementDate, // 고시일자(O)
        @JsonProperty("법정동코드") String legalDistrictCode, // 법정동 코드(O)
        @JsonProperty("특수지코드") String specialLandCode, // 특수지 코드
        @JsonProperty("번지") String lotNumber, // 번지 (O)
        @JsonProperty("호") String unitNumber, // 호 (O)
        @JsonProperty("상가건물블록주소") String buildingBlockAddress, // 상가 건물 블록 주소(O)
        @JsonProperty("상가건물동주소") String buildingUnitAddress, // 상가 건물 동 주소(O)
        @JsonProperty("건물층구분코드") String buildingFloorCode, // 건물 층 구분 코드 (O)
        @JsonProperty("상가건물층주소") String buildingFloorAddress, // 상가 건물 층 주소(O)
        @JsonProperty("상가건물호주소") String buildingUnitFloorAddress, // 상가 건물 호 주소 (O)
        @JsonProperty("고시가격") String announcedPrice, // 고시 가격 (O)
        @JsonProperty("전용면적") String exclusiveArea, // 전용 면적 (O)
        @JsonProperty("공유면적") String commonArea // 공용 면적 (O)

) {
    public OfficetelValuation toOfficetelValuation() {
        return OfficetelValuation.builder()
                .buildingNumber(buildingNumber)
                .buildingType(buildingType)
                .announcementDate(announcementDate)
                .legalDistrictCode(legalDistrictCode)
                .specialLandCode(specialLandCode)
                .lotNumber(lotNumber)
                .unitNumber(unitNumber)
                .buildingBlockAddress(buildingBlockAddress)
                .buildingUnitAddress(buildingUnitAddress)
                .buildingFloorCode(buildingFloorCode)
                .buildingFloorAddress(buildingFloorAddress)
                .buildingUnitFloorAddress(buildingUnitFloorAddress)
                .announcedPrice(announcedPrice)
                .exclusiveArea(exclusiveArea)
                .commonArea(commonArea)
                .build();
    }
}
