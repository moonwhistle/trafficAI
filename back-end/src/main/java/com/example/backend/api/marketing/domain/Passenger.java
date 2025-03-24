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
// 서울시 행정동별 대중교통 총 승차 승객수
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String crtrDd;  // 기준_날짜

    @Column(nullable = false)
    private String dongId;  // 행정동_ID

    @Column(nullable = false)
    private long psngNo;    // 승객_수

    @Column(nullable = false)
    private long psngNo00;  // 승객_수_00시

    @Column(nullable = false)
    private long psngNo01;  // 승객_수_01시

    @Column(nullable = false)
    private long psngNo02;  // 승객_수_02시

    @Column(nullable = false)
    private long psngNo03;  // 승객_수_03시

    @Column(nullable = false)
    private long psngNo04;  // 승객_수_04시

    @Column(nullable = false)
    private long psngNo05;  // 승객_수_05시

    @Column(nullable = false)
    private long psngNo06;  // 승객_수_06시

    @Column(nullable = false)
    private long psngNo07;  // 승객_수_07시

    @Column(nullable = false)
    private long psngNo08;  // 승객_수_08시

    @Column(nullable = false)
    private long psngNo09;  // 승객_수_09시

    @Column(nullable = false)
    private long psngNo10;  // 승객_수_10시

    @Column(nullable = false)
    private long psngNo11;  // 승객_수_11시

    @Column(nullable = false)
    private long psngNo12;  // 승객_수_12시

    @Column(nullable = false)
    private long psngNo13;  // 승객_수_13시

    @Column(nullable = false)
    private long psngNo14;  // 승객_수_14시

    @Column(nullable = false)
    private long psngNo15;  // 승객_수_15시

    @Column(nullable = false)
    private long psngNo16;  // 승객_수_16시

    @Column(nullable = false)
    private long psngNo17;  // 승객_수_17시

    @Column(nullable = false)
    private long psngNo18;  // 승객_수_18시

    @Column(nullable = false)
    private long psngNo19;  // 승객_수_19시

    @Column(nullable = false)
    private long psngNo20;  // 승객_수_20시

    @Column(nullable = false)
    private long psngNo21;  // 승객_수_21시

    @Column(nullable = false)
    private long psngNo22;  // 승객_수_22시

    @Column(nullable = false)
    private long psngNo23;  // 승객_수_23시
}
