package com.example.backend.api.marketing.service.dto;

import com.example.backend.api.marketing.domain.Passenger;
import com.fasterxml.jackson.annotation.JsonProperty;

public record PassengerRequest(
        @JsonProperty("CRTR_DD") String crtrDd,   // 기준_날짜
        @JsonProperty("DONG_ID") String dongId,   // 행정동_ID
        @JsonProperty("PSNG_NO") long psngNo,     // 승객_수
        @JsonProperty("PSNG_NO_00") long psngNo00, // 승객_수_00시
        @JsonProperty("PSNG_NO_01") long psngNo01, // 승객_수_01시
        @JsonProperty("PSNG_NO_02") long psngNo02, // 승객_수_02시
        @JsonProperty("PSNG_NO_03") long psngNo03, // 승객_수_03시
        @JsonProperty("PSNG_NO_04") long psngNo04, // 승객_수_04시
        @JsonProperty("PSNG_NO_05") long psngNo05, // 승객_수_05시
        @JsonProperty("PSNG_NO_06") long psngNo06, // 승객_수_06시
        @JsonProperty("PSNG_NO_07") long psngNo07, // 승객_수_07시
        @JsonProperty("PSNG_NO_08") long psngNo08, // 승객_수_08시
        @JsonProperty("PSNG_NO_09") long psngNo09, // 승객_수_09시
        @JsonProperty("PSNG_NO_10") long psngNo10, // 승객_수_10시
        @JsonProperty("PSNG_NO_11") long psngNo11, // 승객_수_11시
        @JsonProperty("PSNG_NO_12") long psngNo12, // 승객_수_12시
        @JsonProperty("PSNG_NO_13") long psngNo13, // 승객_수_13시
        @JsonProperty("PSNG_NO_14") long psngNo14, // 승객_수_14시
        @JsonProperty("PSNG_NO_15") long psngNo15, // 승객_수_15시
        @JsonProperty("PSNG_NO_16") long psngNo16, // 승객_수_16시
        @JsonProperty("PSNG_NO_17") long psngNo17, // 승객_수_17시
        @JsonProperty("PSNG_NO_18") long psngNo18, // 승객_수_18시
        @JsonProperty("PSNG_NO_19") long psngNo19, // 승객_수_19시
        @JsonProperty("PSNG_NO_20") long psngNo20, // 승객_수_20시
        @JsonProperty("PSNG_NO_21") long psngNo21, // 승객_수_21시
        @JsonProperty("PSNG_NO_22") long psngNo22, // 승객_수_22시
        @JsonProperty("PSNG_NO_23") long psngNo23  // 승객_수_23시
) {

    public Passenger toPassenger() {
        return Passenger.builder()
                .crtrDd(crtrDd)
                .dongId(dongId)
                .psngNo(psngNo)
                .psngNo00(psngNo00)
                .psngNo01(psngNo01)
                .psngNo02(psngNo02)
                .psngNo03(psngNo03)
                .psngNo04(psngNo04)
                .psngNo05(psngNo05)
                .psngNo06(psngNo06)
                .psngNo07(psngNo07)
                .psngNo08(psngNo08)
                .psngNo09(psngNo09)
                .psngNo10(psngNo10)
                .psngNo11(psngNo11)
                .psngNo12(psngNo12)
                .psngNo13(psngNo13)
                .psngNo14(psngNo14)
                .psngNo15(psngNo15)
                .psngNo16(psngNo16)
                .psngNo17(psngNo17)
                .psngNo18(psngNo18)
                .psngNo19(psngNo19)
                .psngNo20(psngNo20)
                .psngNo21(psngNo21)
                .psngNo22(psngNo22)
                .psngNo23(psngNo23)
                .build();
    }
}
