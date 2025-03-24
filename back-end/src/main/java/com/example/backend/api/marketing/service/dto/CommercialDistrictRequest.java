package com.example.backend.api.marketing.service.dto;

import com.example.backend.api.marketing.domain.ExpenditureCommercialDistrict;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CommercialDistrictRequest(
        @JsonProperty("STDR_YYQU_CD") String stdrYyquCd,  // 기준_년분기_코드
        @JsonProperty("TRDAR_SE_CD") String trdarSeCd,   // 상권_구분_코드
        @JsonProperty("TRDAR_SE_CD_NM") String trdarSeCdNm, // 상권_구분_코드_명
        @JsonProperty("TRDAR_CD") String trdarCd,     // 상권_코드
        @JsonProperty("TRDAR_CD_NM") String trdarCdNm,   // 상권_코드_명
        @JsonProperty("MT_AVRG_INCOME_AMT") long mtAvrgIncomeAmt, // 월_평균_소득_금액
        @JsonProperty("INCOME_SCTN_CD") String incomeSctnCd,  // 소득_구간_코드
        @JsonProperty("EXPNDTR_TOTAMT") long expndtrTotamt,   // 지출_총금액
        @JsonProperty("FDSTFFS_EXPNDTR_TOTAMT") long fdstffsExpndtrTotamt, // 식료품_지출_총금액
        @JsonProperty("CLTHS_FTWR_EXPNDTR_TOTAMT") long clthsFtwrExpndtrTotamt, // 의류_신발_지출_총금액
        @JsonProperty("LVSPL_EXPNDTR_TOTAMT") long lvSplExpndtrTotamt, // 생활용품_지출_총금액
        @JsonProperty("MCP_EXPNDTR_TOTAMT") long mcpExpndtrTotamt,  // 의료비_지출_총금액
        @JsonProperty("TRNSPORT_EXPNDTR_TOTAMT") long trnsportExpndtrTotamt, // 교통_지출_총금액
        @JsonProperty("LSR_EXPNDTR_TOTAMT") long lsrExpndtrTotamt, // 여가_지출_총금액
        @JsonProperty("CLTUR_EXPNDTR_TOTAMT") long clturExpndtrTotamt, // 문화_지출_총금액
        @JsonProperty("EDC_EXPNDTR_TOTAMT") long edcExpndtrTotamt, // 교육_지출_총금액
        @JsonProperty("PLESR_EXPNDTR_TOTAMT") long plesrExpndtrTotamt // 유흥_지출_총금액
) {

    public ExpenditureCommercialDistrict toCommercialDistrict() {
        return ExpenditureCommercialDistrict.builder()
                .stdrYyquCd(stdrYyquCd)
                .trdarSeCd(trdarSeCd)
                .trdarSeCdNm(trdarSeCdNm)
                .trdarCd(trdarCd)
                .trdarCdNm(trdarCdNm)
                .mtAvrgIncomeAmt(mtAvrgIncomeAmt)
                .incomeSctnCd(incomeSctnCd)
                .expndtrTotamt(expndtrTotamt)
                .fdstffsExpndtrTotamt(fdstffsExpndtrTotamt)
                .clthsFtwrExpndtrTotamt(clthsFtwrExpndtrTotamt)
                .lvSplExpndtrTotamt(lvSplExpndtrTotamt)
                .mcpExpndtrTotamt(mcpExpndtrTotamt)
                .trnsportExpndtrTotamt(trnsportExpndtrTotamt)
                .lsrExpndtrTotamt(lsrExpndtrTotamt)
                .clturExpndtrTotamt(clturExpndtrTotamt)
                .edcExpndtrTotamt(edcExpndtrTotamt)
                .plesrExpndtrTotamt(plesrExpndtrTotamt)
                .build();
    }
}

