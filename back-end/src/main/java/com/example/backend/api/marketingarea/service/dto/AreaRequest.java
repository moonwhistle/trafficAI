package com.example.backend.api.marketingarea.service.dto;

import com.example.backend.api.marketingarea.domain.ExpenditureArea;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AreaRequest(
        @JsonProperty("STDR_YYQU_CD") String stdrYyquCd,  // 기준_년분기_코드
        @JsonProperty("SIGNGU_CD") String signguCd,   // 행정동_코드
        @JsonProperty("SIGNGU_CD_NM") String signguCdNm, // 행정동_코드_명
        @JsonProperty("MT_AVRG_INCOME_AMT") long mtAvrgIncomeAmt, // 월_평균_소득_금액
        @JsonProperty("INCOME_SCTN_CD") String incomeSctnCd,  // 소득_구간_코드
        @JsonProperty("EXPNDTR_TOTAMT") long expndtrTotamt,   // 지출_총금액
        @JsonProperty("FDSTFFS_EXPNDTR_TOTAMT") long fdstffsExpndtrTotamt, // 식료품_지출_총금액
        @JsonProperty("CLTHS_FTWR_EXPNDTR_TOTAMT") long clthsFtwrExpndtrTotamt, // 의류_신발_지출_총금액
        @JsonProperty("LVSPL_EXPNDTR_TOTAMT") long lvSplExpndtrTotamt, // 생활용품_지출_총금액
        @JsonProperty("MCP_EXPNDTR_TOTAMT") long mcpExpndtrTotamt,  // 의료비_지출_총금액
        @JsonProperty("TRNSPORT_EXPNDTR_TOTAMT") long trnsportExpndtrTotamt, // 교통_지출_총금액
        @JsonProperty("EDC_EXPNDTR_TOTAMT") long edcExpndtrTotamt, // 교육_지출_총금액
        @JsonProperty("PLESR_EXPNDTR_TOTAMT") long plesrExpndtrTotamt, // 유흥_지출_총금액
        @JsonProperty("LSR_CLTUR_EXPNDTR_TOTAMT") long lsrClturExpndtrTotamt, // 여가_문화_지출_총금액
        @JsonProperty("ETC_EXPNDTR_TOTAMT") long etcExpndtrTotamt, // 기타_지출_총금액
        @JsonProperty("FD_EXPNDTR_TOTAMT") long fdExpndtrTotamt  // 음식_지출_총금액
) {

    public ExpenditureArea toExpenditureArea() {
        return ExpenditureArea.builder()
                .stdrYyquCd(stdrYyquCd)
                .signguCd(signguCd)
                .signguCdNm(signguCdNm)
                .mtAvrgIncomeAmt(mtAvrgIncomeAmt)
                .incomeSctnCd(incomeSctnCd)
                .expndtrTotamt(expndtrTotamt)
                .fdstffsExpndtrTotamt(fdstffsExpndtrTotamt)
                .clthsFtwrExpndtrTotamt(clthsFtwrExpndtrTotamt)
                .lvSplExpndtrTotamt(lvSplExpndtrTotamt)
                .mcpExpndtrTotamt(mcpExpndtrTotamt)
                .trnsportExpndtrTotamt(trnsportExpndtrTotamt)
                .edcExpndtrTotamt(edcExpndtrTotamt)
                .plesrExpndtrTotamt(plesrExpndtrTotamt)
                .lsrClturExpndtrTotamt(lsrClturExpndtrTotamt)
                .etcExpndtrTotamt(etcExpndtrTotamt)
                .fdExpndtrTotamt(fdExpndtrTotamt)
                .build();
    }
}
