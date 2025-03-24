package com.example.backend.api.marketing.service.dto;

import com.example.backend.api.marketing.domain.Population;
import com.fasterxml.jackson.annotation.JsonProperty;

public record PopulationRequest(
        @JsonProperty("STDR_YYQU_CD") String stdrYyquCd, // 기준_년분기_코드
        @JsonProperty("ADSTRD_CD") String adstrdCd,     // 행정동_코드
        @JsonProperty("ADSTRD_CD_NM") String adstrdCdNm, // 행정동_코드_명
        @JsonProperty("TOT_FLPOP_CO") long totFlpopCo, // 총_유동인구_수
        @JsonProperty("ML_FLPOP_CO") long mlFlpopCo, // 남성_유동인구_수
        @JsonProperty("FML_FLPOP_CO") long fmlFlpopCo, // 여성_유동인구_수
        @JsonProperty("AGRDE_10_FLPOP_CO") long agrde10FlpopCo, // 연령대_10_유동인구_수
        @JsonProperty("AGRDE_20_FLPOP_CO") long agrde20FlpopCo, // 연령대_20_유동인구_수
        @JsonProperty("AGRDE_30_FLPOP_CO") long agrde30FlpopCo, // 연령대_30_유동인구_수
        @JsonProperty("AGRDE_40_FLPOP_CO") long agrde40FlpopCo, // 연령대_40_유동인구_수
        @JsonProperty("AGRDE_50_FLPOP_CO") long agrde50FlpopCo, // 연령대_50_유동인구_수
        @JsonProperty("AGRDE_60_ABOVE_FLPOP_CO") long agrde60AboveFlpopCo, // 연령대_60_이상_유동인구_수
        @JsonProperty("TMZON_00_06_FLPOP_CO") long tmzon00_06FlpopCo, // 시간대_00_06_유동인구_수
        @JsonProperty("TMZON_06_11_FLPOP_CO") long tmzon06_11FlpopCo, // 시간대_06_11_유동인구_수
        @JsonProperty("TMZON_11_14_FLPOP_CO") long tmzon11_14FlpopCo, // 시간대_11_14_유동인구_수
        @JsonProperty("TMZON_14_17_FLPOP_CO") long tmzon14_17FlpopCo, // 시간대_14_17_유동인구_수
        @JsonProperty("TMZON_17_21_FLPOP_CO") long tmzon17_21FlpopCo, // 시간대_17_21_유동인구_수
        @JsonProperty("TMZON_21_24_FLPOP_CO") long tmzon21_24FlpopCo, // 시간대_21_24_유동인구_수
        @JsonProperty("MON_FLPOP_CO") long monFlpopCo, // 월요일_유동인구_수
        @JsonProperty("TUES_FLPOP_CO") long tuesFlpopCo, // 화요일_유동인구_수
        @JsonProperty("WED_FLPOP_CO") long wedFlpopCo, // 수요일_유동인구_수
        @JsonProperty("THUR_FLPOP_CO") long thurFlpopCo, // 목요일_유동인구_수
        @JsonProperty("FRI_FLPOP_CO") long friFlpopCo, // 금요일_유동인구_수
        @JsonProperty("SAT_FLPOP_CO") long satFlpopCo, // 토요일_유동인구_수
        @JsonProperty("SUN_FLPOP_CO") long sunFlpopCo // 일요일_유동인구_수
) {

    public Population toPopulation() {
        return Population.builder()
                .stdrYyquCd(stdrYyquCd)
                .adstrdCd(adstrdCd)
                .adstrdCdNm(adstrdCdNm)
                .totFlpopCo(totFlpopCo)
                .mlFlpopCo(mlFlpopCo)
                .fmlFlpopCo(fmlFlpopCo)
                .agrde10FlpopCo(agrde10FlpopCo)
                .agrde20FlpopCo(agrde20FlpopCo)
                .agrde30FlpopCo(agrde30FlpopCo)
                .agrde40FlpopCo(agrde40FlpopCo)
                .agrde50FlpopCo(agrde50FlpopCo)
                .agrde60AboveFlpopCo(agrde60AboveFlpopCo)
                .tmzon00_06FlpopCo(tmzon00_06FlpopCo)
                .tmzon06_11FlpopCo(tmzon06_11FlpopCo)
                .tmzon11_14FlpopCo(tmzon11_14FlpopCo)
                .tmzon14_17FlpopCo(tmzon14_17FlpopCo)
                .tmzon17_21FlpopCo(tmzon17_21FlpopCo)
                .tmzon21_24FlpopCo(tmzon21_24FlpopCo)
                .monFlpopCo(monFlpopCo)
                .tuesFlpopCo(tuesFlpopCo)
                .wedFlpopCo(wedFlpopCo)
                .thurFlpopCo(thurFlpopCo)
                .friFlpopCo(friFlpopCo)
                .satFlpopCo(satFlpopCo)
                .sunFlpopCo(sunFlpopCo)
                .build();
    }
}
