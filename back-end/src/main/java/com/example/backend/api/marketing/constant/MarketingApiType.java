package com.example.backend.api.marketing.constant;

import lombok.Getter;

@Getter
public enum MarketingApiType {
    // 상권분석 (소득소비 - 상권)
    INCOME_CONSUMPTION_MARKETING_AREA("trdarNcmCnsmp"),
    // 상권분석 (점포 - 상권)
    STORE_MARKETING_AREA("VwsmTrdarStorQq"),
    // 상권분석 (길단위인구 - 행정동)
    ROAD_UNIT_POPULATION_ADMINISTRATIVE_DONG("VwsmAdstrdFlpopW"),
    // 서울시 상권분석서비스(추정매출-상권)
    ESTIMATED_SALES_MARKETING_AREA("VwsmTrdarSelngQq"),
    // 서울시 행정동별 대중교통 총 승차 승객수
    PASSENGER_MARKETING_AREA("tpssPassengerCnt"),
    // 오피스텔 시가 정보_1
    OFFICETEL_VALUATION_1("4668bee5-fbfd-41b1-a521-c839c3e01615_201909281433"),
    // 오피스텔 시가 정보_2
    OFFICETEL_VALUATION_2("45bfecd8-456a-430d-8a59-bd3d1145835e");


    private final String type;

    MarketingApiType(String type) {
        this.type = type;
    }
}
