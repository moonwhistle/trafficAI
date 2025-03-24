package com.example.backend.api.marketingarea.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
// 상권분석 (소득소비 - 자치구, 행정동)
public class ExpenditureArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String stdrYyquCd;  // 기준_년분기_코드

    @Column(nullable = false)
    private String signguCd;  // 행정동_코드

    @Column(nullable = false)
    private String signguCdNm;  // 행정동_코드_명

    @Column(nullable = false)
    private long mtAvrgIncomeAmt;  // 월_평균_소득_금액

    @Column(nullable = false)
    private String incomeSctnCd;  // 소득_구간_코드

    @Column(nullable = false)
    private long expndtrTotamt;  // 지출_총금액

    @Column(nullable = false)
    private long fdstffsExpndtrTotamt;  // 식료품_지출_총금액

    @Column(nullable = false)
    private long clthsFtwrExpndtrTotamt;  // 의류_신발_지출_총금액

    @Column(nullable = false)
    private long lvSplExpndtrTotamt;  // 생활용품_지출_총금액

    @Column(nullable = false)
    private long mcpExpndtrTotamt;  // 의료비_지출_총금액

    @Column(nullable = false)
    private long trnsportExpndtrTotamt;  // 교통_지출_총금액

    @Column(nullable = false)
    private long edcExpndtrTotamt;  // 교육_지출_총금액

    @Column(nullable = false)
    private long plesrExpndtrTotamt;  // 유흥_지출_총금액

    @Column(nullable = false)
    private long lsrClturExpndtrTotamt;  // 여가_문화_지출_총금액

    @Column(nullable = false)
    private long etcExpndtrTotamt;  // 기타_지출_총금액

    @Column(nullable = false)
    private long fdExpndtrTotamt;  // 음식_지출_총금액
}
