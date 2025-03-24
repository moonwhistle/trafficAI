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
// 서울시 상권분석서비스(추정매출-상권)
public class EstimatedSales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String stdrYyquCd;  // 기준_년분기_코드

    @Column(nullable = false)
    private String trdarSeCd;   // 상권_구분_코드

    @Column(nullable = false)
    private String trdarSeCdNm; // 상권_구분_코드_명

    @Column(nullable = false)
    private String trdarCd;     // 상권_코드

    @Column(nullable = false)
    private String trdarCdNm;   // 상권_코드_명

    @Column(nullable = false)
    private String svcIndutyCd; // 서비스_업종_코드

    @Column(nullable = false)
    private String svcIndutyCdNm; // 서비스_업종_코드_명

    @Column(nullable = false)
    private double thsmonSelngAmt;  // 당월_매출_금액

    @Column(nullable = false)
    private long thsmonSelngCo;    // 당월_매출_건수

    @Column(nullable = false)
    private double mdwkSelngAmt;   // 주중_매출_금액

    @Column(nullable = false)
    private double wkendSelngAmt;  // 주말_매출_금액

    @Column(nullable = false)
    private double monSelngAmt;    // 월요일_매출_금액

    @Column(nullable = false)
    private double tuesSelngAmt;   // 화요일_매출_금액

    @Column(nullable = false)
    private double wedSelngAmt;    // 수요일_매출_금액

    @Column(nullable = false)
    private double thurSelngAmt;   // 목요일_매출_금액

    @Column(nullable = false)
    private double friSelngAmt;    // 금요일_매출_금액

    @Column(nullable = false)
    private double satSelngAmt;    // 토요일_매출_금액

    @Column(nullable = false)
    private double sunSelngAmt;    // 일요일_매출_금액

    @Column(nullable = false)
    private double tmzon00To06SelngAmt; // 시간대_00~06_매출_금액

    @Column(nullable = false)
    private double tmzon06To11SelngAmt; // 시간대_06~11_매출_금액

    @Column(nullable = false)
    private double tmzon11To14SelngAmt; // 시간대_11~14_매출_금액

    @Column(nullable = false)
    private double tmzon14To17SelngAmt; // 시간대_14~17_매출_금액

    @Column(nullable = false)
    private double tmzon17To21SelngAmt; // 시간대_17~21_매출_금액

    @Column(nullable = false)
    private double tmzon21To24SelngAmt; // 시간대_21~24_매출_금액

    @Column(nullable = false)
    private double mlSelngAmt;      // 남성_매출_금액

    @Column(nullable = false)
    private double fmlSelngAmt;     // 여성_매출_금액

    @Column(nullable = false)
    private double agrde10SelngAmt; // 연령대_10_매출_금액

    @Column(nullable = false)
    private double agrde20SelngAmt; // 연령대_20_매출_금액

    @Column(nullable = false)
    private double agrde30SelngAmt; // 연령대_30_매출_금액

    @Column(nullable = false)
    private double agrde40SelngAmt; // 연령대_40_매출_금액

    @Column(nullable = false)
    private double agrde50SelngAmt; // 연령대_50_매출_금액

    @Column(nullable = false)
    private double agrde60AboveSelngAmt; // 연령대_60_이상_매출_금액

    @Column(nullable = false)
    private long mdwkSelngCo;     // 주중_매출_건수

    @Column(nullable = false)
    private long wkendSelngCo;    // 주말_매출_건수

    @Column(nullable = false)
    private long monSelngCo;      // 월요일_매출_건수

    @Column(nullable = false)
    private long tuesSelngCo;     // 화요일_매출_건수

    @Column(nullable = false)
    private long wedSelngCo;      // 수요일_매출_건수

    @Column(nullable = false)
    private long thurSelngCo;     // 목요일_매출_건수

    @Column(nullable = false)
    private long friSelngCo;      // 금요일_매출_건수

    @Column(nullable = false)
    private long satSelngCo;      // 토요일_매출_건수

    @Column(nullable = false)
    private long sunSelngCo;      // 일요일_매출_건수

    @Column(nullable = false)
    private long tmzon00To06SelngCo; // 시간대_00~06_매출_건수

    @Column(nullable = false)
    private long tmzon06To11SelngCo; // 시간대_06~11_매출_건수

    @Column(nullable = false)
    private long tmzon11To14SelngCo; // 시간대_11~14_매출_건수

    @Column(nullable = false)
    private long tmzon14To17SelngCo; // 시간대_14~17_매출_건수

    @Column(nullable = false)
    private long tmzon17To21SelngCo; // 시간대_17~21_매출_건수

    @Column(nullable = false)
    private long tmzon21To24SelngCo; // 시간대_21~24_매출_건수

    @Column(nullable = false)
    private long mlSelngCo;        // 남성_매출_건수

    @Column(nullable = false)
    private long fmlSelngCo;       // 여성_매출_건수

    @Column(nullable = false)
    private long agrde10SelngCo;   // 연령대_10_매출_건수

    @Column(nullable = false)
    private long agrde20SelngCo;   // 연령대_20_매출_건수

    @Column(nullable = false)
    private long agrde30SelngCo;   // 연령대_30_매출_건수

    @Column(nullable = false)
    private long agrde40SelngCo;   // 연령대_40_매출_건수

    @Column(nullable = false)
    private long agrde50SelngCo;   // 연령대_50_매출_건수

    @Column(nullable = false)
    private long agrde60AboveSelngCo; // 연령대_60_이상_매출_건수
}
