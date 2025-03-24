package com.example.backend.api.marketing.domain;

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
// 상권분석 (길단위인구 - 행정동)
public class Population {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 기준_년분기_코드
    @Column(nullable = false)
    private String stdrYyquCd;

    // 행정동_코드
    @Column(nullable = false)
    private String adstrdCd;

    // 행정동_코드_명
    @Column(nullable = false)
    private String adstrdCdNm;

    // 총_유동인구_수
    @Column(nullable = false)
    private long totFlpopCo;

    // 남성_유동인구_수
    @Column(nullable = false)
    private long mlFlpopCo;

    // 여성_유동인구_수
    @Column(nullable = false)
    private long fmlFlpopCo;

    // 연령대_10_유동인구_수
    @Column(nullable = false)
    private long agrde10FlpopCo;

    // 연령대_20_유동인구_수
    @Column(nullable = false)
    private long agrde20FlpopCo;

    // 연령대_30_유동인구_수
    @Column(nullable = false)
    private long agrde30FlpopCo;

    // 연령대_40_유동인구_수
    @Column(nullable = false)
    private long agrde40FlpopCo;

    // 연령대_50_유동인구_수
    @Column(nullable = false)
    private long agrde50FlpopCo;

    // 연령대_60_이상_유동인구_수
    @Column(nullable = false)
    private long agrde60AboveFlpopCo;

    // 시간대_00_06_유동인구_수
    @Column(nullable = false)
    private long tmzon00_06FlpopCo;

    // 시간대_06_11_유동인구_수
    @Column(nullable = false)
    private long tmzon06_11FlpopCo;

    // 시간대_11_14_유동인구_수
    @Column(nullable = false)
    private long tmzon11_14FlpopCo;

    // 시간대_14_17_유동인구_수
    @Column(nullable = false)
    private long tmzon14_17FlpopCo;

    // 시간대_17_21_유동인구_수
    @Column(nullable = false)
    private long tmzon17_21FlpopCo;

    // 시간대_21_24_유동인구_수
    @Column(nullable = false)
    private long tmzon21_24FlpopCo;

    // 월요일_유동인구_수
    @Column(nullable = false)
    private long monFlpopCo;

    // 화요일_유동인구_수
    @Column(nullable = false)
    private long tuesFlpopCo;

    // 수요일_유동인구_수
    @Column(nullable = false)
    private long wedFlpopCo;

    // 목요일_유동인구_수
    @Column(nullable = false)
    private long thurFlpopCo;

    // 금요일_유동인구_수
    @Column(nullable = false)
    private long friFlpopCo;

    // 토요일_유동인구_수
    @Column(nullable = false)
    private long satFlpopCo;

    // 일요일_유동인구_수
    @Column(nullable = false)
    private long sunFlpopCo;
}
