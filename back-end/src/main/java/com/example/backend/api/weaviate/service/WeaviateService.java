package com.example.backend.api.weaviate.service;

import io.weaviate.client.WeaviateClient;
import io.weaviate.client.base.Result;
import io.weaviate.client.v1.schema.model.Property;
import io.weaviate.client.v1.schema.model.WeaviateClass;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaviateService {

    private final WeaviateClient weaviateClient;

    public WeaviateService(WeaviateClient weaviateClient) {
        this.weaviateClient = weaviateClient;
    }

    public boolean isWeaviateReady() {
        try {
            Result<Boolean> result = weaviateClient.misc().readyChecker().run();
            return result.getResult();
        } catch (Exception e) {
            System.err.println("Weaviate 서버 준비 상태 확인 실패: " + e.getMessage());
            return false;
        }
    }

    public void createAllSchemas() {
        //createEstimatedSalesSchema();
        //createExpenditureCommercialDistrictSchema();
        //createOfficetelValuationSchema();
        //createPassengerSchema();
        //createPopulationSchema();
        //createStoreSchema();
        //createaddressSchema();
        //createEstatechema();
    }

    private void createEstimatedSalesSchema() {
        List<Property> properties = List.of(
                Property.builder().name("unique_id").dataType(List.of("int")).build(),  // ID 추가

                // 숫자 (매출 금액 및 건수)
                Property.builder().name("agrde10selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("agrde10selng_co").dataType(List.of("number")).build(),
                Property.builder().name("agrde20selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("agrde20selng_co").dataType(List.of("number")).build(),
                Property.builder().name("agrde30selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("agrde30selng_co").dataType(List.of("number")).build(),
                Property.builder().name("agrde40selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("agrde40selng_co").dataType(List.of("number")).build(),
                Property.builder().name("agrde50selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("agrde50selng_co").dataType(List.of("number")).build(),
                Property.builder().name("agrde60above_selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("agrde60above_selng_co").dataType(List.of("number")).build(),

                Property.builder().name("fml_selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("fml_selng_co").dataType(List.of("number")).build(),
                Property.builder().name("fri_selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("fri_selng_co").dataType(List.of("number")).build(),
                Property.builder().name("mdwk_selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("mdwk_selng_co").dataType(List.of("number")).build(),
                Property.builder().name("ml_selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("ml_selng_co").dataType(List.of("number")).build(),
                Property.builder().name("mon_selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("mon_selng_co").dataType(List.of("number")).build(),
                Property.builder().name("sat_selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("sat_selng_co").dataType(List.of("number")).build(),
                Property.builder().name("sun_selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("sun_selng_co").dataType(List.of("number")).build(),
                Property.builder().name("thsmon_selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("thsmon_selng_co").dataType(List.of("number")).build(),
                Property.builder().name("thur_selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("thur_selng_co").dataType(List.of("number")).build(),

                // 시간대별 매출
                Property.builder().name("tmzon00to06selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("tmzon00to06selng_co").dataType(List.of("number")).build(),
                Property.builder().name("tmzon06to11selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("tmzon06to11selng_co").dataType(List.of("number")).build(),
                Property.builder().name("tmzon11to14selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("tmzon11to14selng_co").dataType(List.of("number")).build(),
                Property.builder().name("tmzon14to17selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("tmzon14to17selng_co").dataType(List.of("number")).build(),
                Property.builder().name("tmzon17to21selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("tmzon17to21selng_co").dataType(List.of("number")).build(),
                Property.builder().name("tmzon21to24selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("tmzon21to24selng_co").dataType(List.of("number")).build(),

                // 요일별 매출
                Property.builder().name("tues_selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("tues_selng_co").dataType(List.of("number")).build(),
                Property.builder().name("wed_selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("wed_selng_co").dataType(List.of("number")).build(),
                Property.builder().name("wkend_selng_amt").dataType(List.of("number")).build(),
                Property.builder().name("wkend_selng_co").dataType(List.of("number")).build(),

                // 문자열 (카테고리)
                Property.builder().name("stdr_yyqu_cd").dataType(List.of("string")).build(),
                Property.builder().name("svc_induty_cd").dataType(List.of("string")).build(),
                Property.builder().name("svc_induty_cd_nm").dataType(List.of("string")).build(),
                Property.builder().name("trdar_cd").dataType(List.of("string")).build(),
                Property.builder().name("trdar_cd_nm").dataType(List.of("string")).build(),
                Property.builder().name("trdar_se_cd").dataType(List.of("string")).build(),
                Property.builder().name("trdar_se_cd_nm").dataType(List.of("string")).build()
        );

        WeaviateClass estimatedSalesClass = WeaviateClass.builder()
                .className("EstimatedSales")
                .properties(properties)
                .build();

        Result<Boolean> result = weaviateClient.schema().classCreator()
                .withClass(estimatedSalesClass)
                .run();

        System.out.println(result);

        Result<WeaviateClass> existingClass = weaviateClient.schema().classGetter()
                .withClassName("EstimatedSales")
                .run();

        System.out.println(existingClass.getResult());
    }

    private void createExpenditureCommercialDistrictSchema() {
        List<Property> properties = List.of(
                Property.builder().name("unique_id").dataType(List.of("string")).build(), // bigint AI PK → string 변환
                Property.builder().name("clths_ftwr_expndtr_totamt").dataType(List.of("number")).build(),
                Property.builder().name("cltur_expndtr_totamt").dataType(List.of("number")).build(),
                Property.builder().name("edc_expndtr_totamt").dataType(List.of("number")).build(),
                Property.builder().name("expndtr_totamt").dataType(List.of("number")).build(),
                Property.builder().name("fdstffs_expndtr_totamt").dataType(List.of("number")).build(),
                Property.builder().name("income_sctn_cd").dataType(List.of("string")).build(),
                Property.builder().name("lsr_expndtr_totamt").dataType(List.of("number")).build(),
                Property.builder().name("lv_spl_expndtr_totamt").dataType(List.of("number")).build(),
                Property.builder().name("mcp_expndtr_totamt").dataType(List.of("number")).build(),
                Property.builder().name("mt_avrg_income_amt").dataType(List.of("number")).build(),
                Property.builder().name("plesr_expndtr_totamt").dataType(List.of("number")).build(),
                Property.builder().name("stdr_yyqu_cd").dataType(List.of("string")).build(),
                Property.builder().name("trdar_cd").dataType(List.of("string")).build(),
                Property.builder().name("trdar_cd_nm").dataType(List.of("string")).build(),
                Property.builder().name("trdar_se_cd").dataType(List.of("string")).build(),
                Property.builder().name("trdar_se_cd_nm").dataType(List.of("string")).build(),
                Property.builder().name("trnsport_expndtr_totamt").dataType(List.of("number")).build()
        );

        WeaviateClass commercialDistrictClass = WeaviateClass.builder()
                .className("ExpenditureCommercialDistrict")
                .properties(properties)
                .build();

        Result<Boolean> result = weaviateClient.schema().classCreator().withClass(commercialDistrictClass).run();
        System.out.println(result);

        Result<WeaviateClass> existingClass = weaviateClient.schema().classGetter()
                .withClassName("ExpenditureCommercialDistrict").run();

        if (existingClass.getResult() != null) {
            System.out.println("ExpenditureCommercialDistrict 컬렉션이 이미 존재합니다.");
        }
    }

    private void createOfficetelValuationSchema() {
        List<Property> properties = List.of(
                Property.builder().name("unique_id").dataType(List.of("string")).build(),
                Property.builder().name("official_price").dataType(List.of("string")).build(),  // 고시가격 -> official_price
                Property.builder().name("official_date").dataType(List.of("string")).build(),  // 고시일자 -> official_date
                Property.builder().name("building_block_address").dataType(List.of("string")).build(),  // 상가건물블록주소 -> building_block_address
                Property.builder().name("building_floor_address").dataType(List.of("string")).build(),  // 상가건물층주소 -> building_floor_address
                Property.builder().name("building_floor_type_code").dataType(List.of("string")).build(),  // 건물층구분코드 -> building_floor_type_code
                Property.builder().name("building_number").dataType(List.of("string")).build(),  // 상가건물번호 -> building_number
                Property.builder().name("building_type_code").dataType(List.of("string")).build(),  // 상가종류코드 -> building_type_code
                Property.builder().name("building_block_subaddress").dataType(List.of("string")).build(),  // 상가건물동주소 -> building_block_subaddress
                Property.builder().name("building_floor_subaddress").dataType(List.of("string")).build(),  // 상가건물호주소 -> building_floor_subaddress
                Property.builder().name("shared_area").dataType(List.of("string")).build(),  // 공유면적 -> shared_area
                Property.builder().name("exclusive_area").dataType(List.of("string")).build(),  // 전용면적 -> exclusive_area
                Property.builder().name("legal_dong_code").dataType(List.of("string")).build(),  // 법정동코드 -> legal_dong_code
                Property.builder().name("land_number").dataType(List.of("string")).build(),  // 번지 -> land_number
                Property.builder().name("special_land_code").dataType(List.of("string")).build(),  // 특수지코드 -> special_land_code
                Property.builder().name("unit_number").dataType(List.of("string")).build()  // 호 -> unit_number
        );

        WeaviateClass officetelClass = WeaviateClass.builder()
                .className("OfficetelValuation")
                .properties(properties)
                .build();

        Result<Boolean> result = weaviateClient.schema().classCreator().withClass(officetelClass).run();
        System.out.println(result);

        Result<WeaviateClass> existingClass = weaviateClient.schema().classGetter().withClassName("OfficetelValuation").run();
        System.out.println(existingClass.getResult());

    }

    private void createPassengerSchema() {
        List<Property> properties = List.of(
                Property.builder().name("crtr_dd").dataType(List.of("string")).build(),  // crtr_dd: varchar(255) -> string
                Property.builder().name("dong_id").dataType(List.of("string")).build(),  // dong_id: varchar(255) -> string
                Property.builder().name("psng_no").dataType(List.of("int")).build(),  // psng_no: bigint -> int
                Property.builder().name("psng_no00").dataType(List.of("int")).build(),  // psng_no00: bigint -> int
                Property.builder().name("psng_no01").dataType(List.of("int")).build(),  // psng_no01: bigint -> int
                Property.builder().name("psng_no02").dataType(List.of("int")).build(),  // psng_no02: bigint -> int
                Property.builder().name("psng_no03").dataType(List.of("int")).build(),  // psng_no03: bigint -> int
                Property.builder().name("psng_no04").dataType(List.of("int")).build(),  // psng_no04: bigint -> int
                Property.builder().name("psng_no05").dataType(List.of("int")).build(),  // psng_no05: bigint -> int
                Property.builder().name("psng_no06").dataType(List.of("int")).build(),  // psng_no06: bigint -> int
                Property.builder().name("psng_no07").dataType(List.of("int")).build(),  // psng_no07: bigint -> int
                Property.builder().name("psng_no08").dataType(List.of("int")).build(),  // psng_no08: bigint -> int
                Property.builder().name("psng_no09").dataType(List.of("int")).build(),  // psng_no09: bigint -> int
                Property.builder().name("psng_no10").dataType(List.of("int")).build(),  // psng_no10: bigint -> int
                Property.builder().name("psng_no11").dataType(List.of("int")).build(),  // psng_no11: bigint -> int
                Property.builder().name("psng_no12").dataType(List.of("int")).build(),  // psng_no12: bigint -> int
                Property.builder().name("psng_no13").dataType(List.of("int")).build(),  // psng_no13: bigint -> int
                Property.builder().name("psng_no14").dataType(List.of("int")).build(),  // psng_no14: bigint -> int
                Property.builder().name("psng_no15").dataType(List.of("int")).build(),  // psng_no15: bigint -> int
                Property.builder().name("psng_no16").dataType(List.of("int")).build(),  // psng_no16: bigint -> int
                Property.builder().name("psng_no17").dataType(List.of("int")).build(),  // psng_no17: bigint -> int
                Property.builder().name("psng_no18").dataType(List.of("int")).build(),  // psng_no18: bigint -> int
                Property.builder().name("psng_no19").dataType(List.of("int")).build(),  // psng_no19: bigint -> int
                Property.builder().name("psng_no20").dataType(List.of("int")).build(),  // psng_no20: bigint -> int
                Property.builder().name("psng_no21").dataType(List.of("int")).build(),  // psng_no21: bigint -> int
                Property.builder().name("psng_no22").dataType(List.of("int")).build(),  // psng_no22: bigint -> int
                Property.builder().name("psng_no23").dataType(List.of("int")).build()   // psng_no23: bigint -> int
        );

        WeaviateClass passengerClass = WeaviateClass.builder()
                .className("Passenger")
                .properties(properties)
                .build();

        // Weaviate에서 Passenger 클래스 생성
        Result<Boolean> result = weaviateClient.schema().classCreator().withClass(passengerClass).run();
        if (result.hasErrors()) {
            System.out.println("Passenger 클래스 생성 실패: " + result.getError());
        } else {
            System.out.println("Passenger 클래스 생성 성공");
        }

        // 생성된 클래스 확인
        Result<WeaviateClass> existingClass = weaviateClient.schema().classGetter().withClassName("Passenger").run();
        if (existingClass.hasErrors()) {
            System.out.println("Passenger 클래스 조회 실패: " + existingClass.getError());
        } else {
            System.out.println("Passenger 클래스 조회 성공: " + existingClass.getResult());
        }
    }


    private void createPopulationSchema() {
        List<Property> properties = List.of(
                Property.builder().name("adstrd_cd_nm").dataType(List.of("string")).build(),
                Property.builder().name("agrde10flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("agrde20flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("agrde30flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("agrde40flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("agrde50flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("agrde60above_flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("fml_flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("fri_flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("unique_id").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("ml_flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("mon_flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("sat_flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("stdr_yyqu_cd").dataType(List.of("string")).build(),
                Property.builder().name("sun_flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("thur_flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("tmzon00_06flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("tmzon06_11flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("tmzon11_14flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("tmzon14_17flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("tmzon17_21flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("tmzon21_24flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("tot_flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("tues_flpop_co").dataType(List.of("number")).build(), // bigint -> number
                Property.builder().name("wed_flpop_co").dataType(List.of("number")).build() // bigint -> number
        );

        WeaviateClass populationClass = WeaviateClass.builder()
                .className("Population")
                .properties(properties)
                .build();

        // Weaviate 스키마 생성
        Result<Boolean> result = weaviateClient.schema().classCreator().withClass(populationClass).run();
        System.out.println(result);

        // 기존 Population 클래스가 존재하는지 확인
        Result<WeaviateClass> existingClass = weaviateClient.schema().classGetter().withClassName("Population").run();
        System.out.println(existingClass.getResult());
    }

    private void createStoreSchema() {
        List<Property> properties = List.of(
                Property.builder().name("clsbiz_rt").dataType(List.of("number")).build(), // double -> number
                Property.builder().name("opbiz_rt").dataType(List.of("number")).build(),   // double -> number

                Property.builder().name("clsbiz_stor_co").dataType(List.of("int")).build(), // bigint -> int
                Property.builder().name("frc_stor_co").dataType(List.of("int")).build(),   // bigint -> int
                Property.builder().name("opbiz_stor_co").dataType(List.of("int")).build(), // bigint -> int
                Property.builder().name("similr_induty_stor_co").dataType(List.of("int")).build(), // bigint -> int
                Property.builder().name("stor_co").dataType(List.of("int")).build(),     // bigint -> int

                Property.builder().name("unique_id").dataType(List.of("int")).build(),   // id -> int

                Property.builder().name("stdr_yyqu_cd").dataType(List.of("string")).build(),

                Property.builder().name("svc_induty_cd").dataType(List.of("string")).build(), // 벡터화된 값은 number[]로 저장
                Property.builder().name("svc_induty_cd_nm").dataType(List.of("string")).build(), // 벡터화된 값은 number[]로 저장
                Property.builder().name("trdar_cd_nm").dataType(List.of("string")).build(), // 벡터화된 값은 number[]로 저장
                Property.builder().name("trdar_cd").dataType(List.of("string")).build(),
                Property.builder().name("trdar_se_cd").dataType(List.of("string")).build(),
                Property.builder().name("trdar_se_cd_nm").dataType(List.of("string")).build()
        );

        WeaviateClass storeClass = WeaviateClass.builder()
                .className("Store")
                .properties(properties)
                .build();

        Result<Boolean> result = weaviateClient.schema().classCreator().withClass(storeClass).run();
        System.out.println(result);

        Result<WeaviateClass> existingClass = weaviateClient.schema().classGetter().withClassName("Store").run();
        System.out.println(existingClass.getResult());
    }


    private void createaddressSchema() {
        List<Property> properties = List.of(
                Property.builder().name("dong_nm").dataType(List.of("string")).build(),
                Property.builder().name("ctpv_nm").dataType(List.of("string")).build(),
                Property.builder().name("dong_id").dataType(List.of("string")).build(),
                Property.builder().name("cgg_nm").dataType(List.of("string")).build()

        );

        WeaviateClass addressClass = WeaviateClass.builder()
                .className("Address_Master")
                .properties(properties)
                .build();

        Result<Boolean> result = weaviateClient.schema().classCreator().withClass(addressClass).run();
        System.out.println(result);

        Result<WeaviateClass> existingClass = weaviateClient.schema().classGetter().withClassName("Address_Master").run();
        System.out.println(existingClass.getResult());
    }

    private void createEstatechema() {
        List<Property> properties = List.of(
                Property.builder().name("district_name").dataType(List.of("string")).build(),
                Property.builder().name("district_code").dataType(List.of("string")).build()

        );

        WeaviateClass estateClass = WeaviateClass.builder()
                .className("Real_Estate")
                .properties(properties)
                .build();

        Result<Boolean> result = weaviateClient.schema().classCreator().withClass(estateClass).run();
        System.out.println(result);

        Result<WeaviateClass> existingClass = weaviateClient.schema().classGetter().withClassName("Real_Estate").run();
        System.out.println(existingClass.getResult());
    }

}
