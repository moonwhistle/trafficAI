package com.example.backend.api.global.constant;

import lombok.Getter;

@Getter
public enum MarketingApiType {
    // 상권분석 (소득소비 - 상권)
    INCOME_CONSUMPTION_MARKETING_AREA("trdarNcmCnsmp"),

    // 상권분석 (소득소비 - 자치구)
    INCOME_CONSUMPTION_DISTRICT("VwsmSignguNcmCnsmpW"),

    // 상권분석 (소득소비 - 행정동)
    INCOME_CONSUMPTION_ADMINISTRATIVE_DONG("VwsmAdstrdNcmCnsmpW"),

    // 상권분석 (점포 - 상권)
    STORE_MARKETING_AREA("VwsmTrdarStorQq"),

    // 상권분석 (상권 변화 지표)
    MARKET_CHANGE_INDEX("VwsmTrdarIxQq"),

    // 상권분석 (직장인구 - 서울시)
    WORKING_POPULATION_SEOUL("VwsmMegaWrcPopltnW"),

    // 상권분석 (길단위인구 - 행정동)
    ROAD_UNIT_POPULATION_ADMINISTRATIVE_DONG("VwsmAdstrdFlpopW"),

    // 상권분석 (점포 - 서울시)
    STORE_SEOUL("VwsmMegaStorW");

    private final String type;

    MarketingApiType(String type) {
        this.type = type;
    }
}
