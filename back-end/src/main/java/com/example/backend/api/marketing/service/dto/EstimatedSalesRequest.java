package com.example.backend.api.marketing.service.dto;

import com.example.backend.api.marketing.domain.EstimatedSales;
import com.fasterxml.jackson.annotation.JsonProperty;

public record EstimatedSalesRequest(
        @JsonProperty("STDR_YYQU_CD") String stdrYyquCd, // 기준_년분기_코드
        @JsonProperty("TRDAR_SE_CD") String trdarSeCd,   // 상권_구분_코드
        @JsonProperty("TRDAR_SE_CD_NM") String trdarSeCdNm, // 상권_구분_코드_명
        @JsonProperty("TRDAR_CD") String trdarCd,       // 상권_코드
        @JsonProperty("TRDAR_CD_NM") String trdarCdNm,   // 상권_코드_명
        @JsonProperty("SVC_INDUTY_CD") String svcIndutyCd, // 서비스_업종_코드
        @JsonProperty("SVC_INDUTY_CD_NM") String svcIndutyCdNm, // 서비스_업종_코드_명
        @JsonProperty("THSMON_SELNG_AMT") double thsmonSelngAmt,  // 당월_매출_금액
        @JsonProperty("THSMON_SELNG_CO") long thsmonSelngCo,    // 당월_매출_건수
        @JsonProperty("MDWK_SELNG_AMT") double mdwkSelngAmt,   // 주중_매출_금액
        @JsonProperty("WKEND_SELNG_AMT") double wkendSelngAmt,  // 주말_매출_금액
        @JsonProperty("MON_SELNG_AMT") double monSelngAmt,    // 월요일_매출_금액
        @JsonProperty("TUES_SELNG_AMT") double tuesSelngAmt,   // 화요일_매출_금액
        @JsonProperty("WED_SELNG_AMT") double wedSelngAmt,    // 수요일_매출_금액
        @JsonProperty("THUR_SELNG_AMT") double thurSelngAmt,   // 목요일_매출_금액
        @JsonProperty("FRI_SELNG_AMT") double friSelngAmt,    // 금요일_매출_금액
        @JsonProperty("SAT_SELNG_AMT") double satSelngAmt,    // 토요일_매출_금액
        @JsonProperty("SUN_SELNG_AMT") double sunSelngAmt,    // 일요일_매출_금액
        @JsonProperty("TMZON_00_06_SELNG_AMT") double tmzon00_06SelngAmt, // 시간대_00~06_매출_금액
        @JsonProperty("TMZON_06_11_SELNG_AMT") double tmzon06_11SelngAmt, // 시간대_06~11_매출_금액
        @JsonProperty("TMZON_11_14_SELNG_AMT") double tmzon11_14SelngAmt, // 시간대_11~14_매출_금액
        @JsonProperty("TMZON_14_17_SELNG_AMT") double tmzon14_17SelngAmt, // 시간대_14~17_매출_금액
        @JsonProperty("TMZON_17_21_SELNG_AMT") double tmzon17_21SelngAmt, // 시간대_17~21_매출_금액
        @JsonProperty("TMZON_21_24_SELNG_AMT") double tmzon21_24SelngAmt, // 시간대_21~24_매출_금액
        @JsonProperty("ML_SELNG_AMT") double mlSelngAmt,      // 남성_매출_금액
        @JsonProperty("FML_SELNG_AMT") double fmlSelngAmt,     // 여성_매출_금액
        @JsonProperty("AGRDE_10_SELNG_AMT") double agrde10SelngAmt, // 연령대_10_매출_금액
        @JsonProperty("AGRDE_20_SELNG_AMT") double agrde20SelngAmt, // 연령대_20_매출_금액
        @JsonProperty("AGRDE_30_SELNG_AMT") double agrde30SelngAmt, // 연령대_30_매출_금액
        @JsonProperty("AGRDE_40_SELNG_AMT") double agrde40SelngAmt, // 연령대_40_매출_금액
        @JsonProperty("AGRDE_50_SELNG_AMT") double agrde50SelngAmt, // 연령대_50_매출_금액
        @JsonProperty("AGRDE_60_ABOVE_SELNG_AMT") double agrde60AboveSelngAmt, // 연령대_60_이상_매출_금액
        @JsonProperty("MDWK_SELNG_CO") long mdwkSelngCo,     // 주중_매출_건수
        @JsonProperty("WKEND_SELNG_CO") long wkendSelngCo,    // 주말_매출_건수
        @JsonProperty("MON_SELNG_CO") long monSelngCo,      // 월요일_매출_건수
        @JsonProperty("TUES_SELNG_CO") long tuesSelngCo,     // 화요일_매출_건수
        @JsonProperty("WED_SELNG_CO") long wedSelngCo,      // 수요일_매출_건수
        @JsonProperty("THUR_SELNG_CO") long thurSelngCo,     // 목요일_매출_건수
        @JsonProperty("FRI_SELNG_CO") long friSelngCo,      // 금요일_매출_건수
        @JsonProperty("SAT_SELNG_CO") long satSelngCo,      // 토요일_매출_건수
        @JsonProperty("SUN_SELNG_CO") long sunSelngCo,      // 일요일_매출_건수
        @JsonProperty("TMZON_00_06_SELNG_CO") long tmzon00_06SelngCo, // 시간대_00~06_매출_건수
        @JsonProperty("TMZON_06_11_SELNG_CO") long tmzon06_11SelngCo, // 시간대_06~11_매출_건수
        @JsonProperty("TMZON_11_14_SELNG_CO") long tmzon11_14SelngCo, // 시간대_11~14_매출_건수
        @JsonProperty("TMZON_14_17_SELNG_CO") long tmzon14_17SelngCo, // 시간대_14~17_매출_건수
        @JsonProperty("TMZON_17_21_SELNG_CO") long tmzon17_21SelngCo, // 시간대_17~21_매출_건수
        @JsonProperty("TMZON_21_24_SELNG_CO") long tmzon21_24SelngCo, // 시간대_21~24_매출_건수
        @JsonProperty("ML_SELNG_CO") long mlSelngCo,        // 남성_매출_건수
        @JsonProperty("FML_SELNG_CO") long fmlSelngCo,       // 여성_매출_건수
        @JsonProperty("AGRDE_10_SELNG_CO") long agrde10SelngCo,   // 연령대_10_매출_건수
        @JsonProperty("AGRDE_20_SELNG_CO") long agrde20SelngCo,   // 연령대_20_매출_건수
        @JsonProperty("AGRDE_30_SELNG_CO") long agrde30SelngCo,   // 연령대_30_매출_건수
        @JsonProperty("AGRDE_40_SELNG_CO") long agrde40SelngCo,   // 연령대_40_매출_건수
        @JsonProperty("AGRDE_50_SELNG_CO") long agrde50SelngCo,   // 연령대_50_매출_건수
        @JsonProperty("AGRDE_60_ABOVE_SELNG_CO") long agrde60AboveSelngCo // 연령대_60_이상_매출_건수
) {

    public EstimatedSales toEstimatedSales() {
        return EstimatedSales.builder()
                .stdrYyquCd(stdrYyquCd)
                .trdarSeCd(trdarSeCd)
                .trdarSeCdNm(trdarSeCdNm)
                .trdarCd(trdarCd)
                .trdarCdNm(trdarCdNm)
                .svcIndutyCd(svcIndutyCd)
                .svcIndutyCdNm(svcIndutyCdNm)
                .thsmonSelngAmt(thsmonSelngAmt)
                .thsmonSelngCo(thsmonSelngCo)
                .mdwkSelngAmt(mdwkSelngAmt)
                .wkendSelngAmt(wkendSelngAmt)
                .monSelngAmt(monSelngAmt)
                .tuesSelngAmt(tuesSelngAmt)
                .wedSelngAmt(wedSelngAmt)
                .thurSelngAmt(thurSelngAmt)
                .friSelngAmt(friSelngAmt)
                .satSelngAmt(satSelngAmt)
                .sunSelngAmt(sunSelngAmt)
                .tmzon00To06SelngAmt(tmzon00_06SelngAmt)
                .tmzon06To11SelngAmt(tmzon06_11SelngAmt)
                .tmzon11To14SelngAmt(tmzon11_14SelngAmt)
                .tmzon14To17SelngAmt(tmzon14_17SelngAmt)
                .tmzon17To21SelngAmt(tmzon17_21SelngAmt)
                .tmzon21To24SelngAmt(tmzon21_24SelngAmt)
                .mlSelngAmt(mlSelngAmt)
                .fmlSelngAmt(fmlSelngAmt)
                .agrde10SelngAmt(agrde10SelngAmt)
                .agrde20SelngAmt(agrde20SelngAmt)
                .agrde30SelngAmt(agrde30SelngAmt)
                .agrde40SelngAmt(agrde40SelngAmt)
                .agrde50SelngAmt(agrde50SelngAmt)
                .agrde60AboveSelngAmt(agrde60AboveSelngAmt)
                .mdwkSelngCo(mdwkSelngCo)
                .wkendSelngCo(wkendSelngCo)
                .monSelngCo(monSelngCo)
                .tuesSelngCo(tuesSelngCo)
                .wedSelngCo(wedSelngCo)
                .thurSelngCo(thurSelngCo)
                .friSelngCo(friSelngCo)
                .satSelngCo(satSelngCo)
                .sunSelngCo(sunSelngCo)
                .tmzon00To06SelngCo(tmzon00_06SelngCo)
                .tmzon06To11SelngCo(tmzon06_11SelngCo)
                .tmzon11To14SelngCo(tmzon11_14SelngCo)
                .tmzon14To17SelngCo(tmzon14_17SelngCo)
                .tmzon17To21SelngCo(tmzon17_21SelngCo)
                .tmzon21To24SelngCo(tmzon21_24SelngCo)
                .mlSelngCo(mlSelngCo)
                .fmlSelngCo(fmlSelngCo)
                .agrde10SelngCo(agrde10SelngCo)
                .agrde20SelngCo(agrde20SelngCo)
                .agrde30SelngCo(agrde30SelngCo)
                .agrde40SelngCo(agrde40SelngCo)
                .agrde50SelngCo(agrde50SelngCo)
                .agrde60AboveSelngCo(agrde60AboveSelngCo)
                .build();
    }
}
