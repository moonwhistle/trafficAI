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
// 상권분석 (점포 - 상권)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String stdrYyquCd;

    @Column(nullable = false)
    private String trdarSeCd;

    @Column(nullable = false)
    private String trdarSeCdNm;

    @Column(nullable = false)
    private String trdarCd;

    @Column(nullable = false)
    private String trdarCdNm;

    @Column(nullable = false)
    private String svcIndutyCd;

    @Column(nullable = false)
    private String svcIndutyCdNm;

    @Column(nullable = false)
    private long storCo;

    @Column(nullable = false)
    private long similrIndutyStorCo;

    @Column(nullable = false)
    private double opbizRt;

    @Column(nullable = false)
    private long opbizStorCo;

    @Column(nullable = false)
    private double clsbizRt;

    @Column(nullable = false)
    private long clsbizStorCo;

    @Column(nullable = false)
    private long frcStorCo;
}
