package com.example.backend.api.marketing.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder

// 오피스텔 기준 시가(공공 데이터 포털)
public class OfficetelValuation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="상가건물번호")
    private String buildingNumber; // 상가 건물 번호

    @Column(name="상가종류코드")
    private String buildingType; // 상가 종류 코드

    @Column(name="고시일자")
    private String announcementDate; // 고시일자

    @Column(name="법정동코드")
    private String legalDistrictCode; // 법정동 코드

    @Column(name="특수지코드")
    private String specialLandCode; // 특수지 코드

    @Column(name="번지")
    private String lotNumber; // 번지

    @Column(name="호")
    private String unitNumber; // 호

    @Column(name="상가건물블록주소")
    private String buildingBlockAddress; // 상가 건물 블록 주소

    @Column(name="상가건물동주소")
    private String buildingUnitAddress; // 상가 건물 동 주소

    @Column(name="건물층구분코드")
    private String buildingFloorCode; // 건물 층 구분 코드

    @Column(name="상가건물층주소")
    private String buildingFloorAddress; // 상가 건물 층 주소

    @Column(name="상가건물호주소")
    private String buildingUnitFloorAddress; // 상가 건물 호 주소

    @Column(name="고시가격")
    private String announcedPrice; // 고시 가격

    @Column(name="전용면적")
    private String exclusiveArea; // 전용 면적

    @Column(name="공유면적")
    private String commonArea; // 공유 면적

}
