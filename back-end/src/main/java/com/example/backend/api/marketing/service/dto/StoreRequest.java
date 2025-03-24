package com.example.backend.api.marketing.service.dto;

import com.example.backend.api.marketing.domain.Store;
import com.fasterxml.jackson.annotation.JsonProperty;

public record StoreRequest(
        @JsonProperty("STDR_YYQU_CD") String stdrYyquCd,  // 기준_년분기_코드
        @JsonProperty("TRDAR_SE_CD") String trdarSeCd,   // 상권_구분_코드
        @JsonProperty("TRDAR_SE_CD_NM") String trdarSeCdNm, // 상권_구분_코드_명
        @JsonProperty("TRDAR_CD") String trdarCd,     // 상권_코드
        @JsonProperty("TRDAR_CD_NM") String trdarCdNm,   // 상권_코드_명
        @JsonProperty("SVC_INDUTY_CD") String svcIndutyCd, // 서비스_업종_코드
        @JsonProperty("SVC_INDUTY_CD_NM") String svcIndutyCdNm, // 서비스_업종_코드_명
        @JsonProperty("STOR_CO") long storCo, // 점포_수
        @JsonProperty("SIMILR_INDUTY_STOR_CO") long similrIndutyStorCo, // 유사_업종_점포_수
        @JsonProperty("OPBIZ_RT") double opbizRt, // 개업_율
        @JsonProperty("OPBIZ_STOR_CO") long opbizStorCo, // 개업_점포_수
        @JsonProperty("CLSBIZ_RT") double clsbizRt, // 폐업_율
        @JsonProperty("CLSBIZ_STOR_CO") long clsbizStorCo, // 폐업_점포_수
        @JsonProperty("FRC_STOR_CO") long frcStorCo // 프랜차이즈_점포_수
) {

    public Store toStore() {
        return Store.builder()
                .stdrYyquCd(stdrYyquCd)
                .trdarSeCd(trdarSeCd)
                .trdarSeCdNm(trdarSeCdNm)
                .trdarCd(trdarCd)
                .trdarCdNm(trdarCdNm)
                .svcIndutyCd(svcIndutyCd)
                .svcIndutyCdNm(svcIndutyCdNm)
                .storCo(storCo)
                .similrIndutyStorCo(similrIndutyStorCo)
                .opbizRt(opbizRt)
                .opbizStorCo(opbizStorCo)
                .clsbizRt(clsbizRt)
                .clsbizStorCo(clsbizStorCo)
                .frcStorCo(frcStorCo)
                .build();
    }
}
