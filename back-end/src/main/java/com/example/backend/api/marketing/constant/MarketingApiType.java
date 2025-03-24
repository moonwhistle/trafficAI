package com.example.backend.api.marketing.constant;

import lombok.Getter;

@Getter
public enum MarketingApiType {
    // 상권분석 (소득소비 - 상권)
    INCOME_CONSUMPTION_MARKETING_AREA("trdarNcmCnsmp"),
    // 상권분석 (점포 - 상권)
    STORE_MARKETING_AREA("VwsmTrdarStorQq"),
    // 상권분석 (길단위인구 - 행정동)
    ROAD_UNIT_POPULATION_ADMINISTRATIVE_DONG("VwsmAdstrdFlpopW");

    private final String type;

    MarketingApiType(String type) {
        this.type = type;
    }
}
