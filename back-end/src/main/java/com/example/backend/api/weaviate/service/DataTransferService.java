package com.example.backend.api.weaviate.service;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import io.weaviate.client.v1.batch.api.ObjectsBatcher;
import io.weaviate.client.v1.data.model.WeaviateObject;
import io.weaviate.client.WeaviateClient;

import javax.sql.DataSource;

@Service
public class DataTransferService {
    private final WeaviateClient weaviateClient;
    private final DataSource dataSource;

    public DataTransferService(WeaviateClient weaviateClient, DataSource dataSource) {
        this.weaviateClient = weaviateClient;
        this.dataSource = dataSource;
    }

    public void transferAllData() {
        transferEstimatedSalesToWeaviate();
        transferExpenditureCommercialDistrictDataToWeaviate();
        //transferOfficetelValuationDataToWeaviate();
        transferPassengerDataToWeaviate();
        transferPopulationDataToWeaviate();
        transferStoreDataToWeaviate();
    }

    public void transferEstimatedSalesToWeaviate() {
        String query = "SELECT * FROM estimated_sales LIMIT 10";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            ObjectsBatcher batcher = weaviateClient.batch().objectsBatcher();
            int count = 0;

            while (rs.next()) {
                Map<String, Object> rowData = new HashMap<>();

                // 정수형 (int)
                int uniqueId = rs.getInt("id");
                rowData.put("unique_id", rs.wasNull() ? null : uniqueId); // NULL 체크

                // 문자열 (string)
                rowData.put("trdar_cd", rs.getString("trdar_cd"));
                rowData.put("trdar_cd_nm", rs.getString("trdar_cd_nm"));
                rowData.put("svc_induty_cd", rs.getString("svc_induty_cd"));
                rowData.put("svc_induty_cd_nm", rs.getString("svc_induty_cd_nm"));
                rowData.put("stdr_yyqu_cd", rs.getString("stdr_yyqu_cd"));
                rowData.put("trdar_se_cd", rs.getString("trdar_se_cd"));
                rowData.put("trdar_se_cd_nm", rs.getString("trdar_se_cd_nm"));

                // 숫자형 (double)
                String[] numericColumns = {
                        "thsmon_selng_amt", "thsmon_selng_co",
                        "agrde10selng_amt", "agrde10selng_co",
                        "agrde20selng_amt", "agrde20selng_co",
                        "agrde30selng_amt", "agrde30selng_co",
                        "agrde40selng_amt", "agrde40selng_co",
                        "agrde50selng_amt", "agrde50selng_co",
                        "agrde60above_selng_amt", "agrde60above_selng_co",
                        "fml_selng_amt", "fml_selng_co",
                        "fri_selng_amt", "fri_selng_co",
                        "mdwk_selng_amt", "mdwk_selng_co",
                        "ml_selng_amt", "ml_selng_co",
                        "mon_selng_amt", "mon_selng_co",
                        "sat_selng_amt", "sat_selng_co",
                        "sun_selng_amt", "sun_selng_co",
                        "thur_selng_amt", "thur_selng_co",
                        "tues_selng_amt", "tues_selng_co",
                        "wed_selng_amt", "wed_selng_co",
                        "wkend_selng_amt", "wkend_selng_co",
                        "tmzon00to06selng_amt", "tmzon00to06selng_co",
                        "tmzon06to11selng_amt", "tmzon06to11selng_co",
                        "tmzon11to14selng_amt", "tmzon11to14selng_co",
                        "tmzon14to17selng_amt", "tmzon14to17selng_co",
                        "tmzon17to21selng_amt", "tmzon17to21selng_co",
                        "tmzon21to24selng_amt", "tmzon21to24selng_co"
                };

                for (String column : numericColumns) {
                    double value = rs.getDouble(column);
                    rowData.put(column, rs.wasNull() ? null : value); // NULL 체크
                }

                batcher.withObject(WeaviateObject.builder()
                        .className("EstimatedSales")
                        .properties(rowData)
                        .build());

                count++;

                if (count % 100 == 0) {
                    batcher.run();
                    batcher = weaviateClient.batch().objectsBatcher();
                }
            }

            if (count % 100 != 0) {
                batcher.run();
            }

            System.out.println("총 " + count + "개의 데이터가 Weaviate에 업로드되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transferExpenditureCommercialDistrictDataToWeaviate() {
        String query = "SELECT * FROM expenditure_commercial_district LIMIT 10";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            ObjectsBatcher batcher = weaviateClient.batch().objectsBatcher();
            int count = 0;

            while (rs.next()) {
                Map<String, Object> rowData = new HashMap<>();

                // MySQL 데이터 읽어오기 (형 변환 주의)
                rowData.put("clths_ftwr_expndtr_totamt", rs.getDouble("clths_ftwr_expndtr_totamt"));
                rowData.put("cltur_expndtr_totamt", rs.getDouble("cltur_expndtr_totamt"));
                rowData.put("edc_expndtr_totamt", rs.getDouble("edc_expndtr_totamt"));
                rowData.put("expndtr_totamt", rs.getDouble("expndtr_totamt"));
                rowData.put("fdstffs_expndtr_totamt", rs.getDouble("fdstffs_expndtr_totamt"));

                // `id`는 bigint -> string 변환
                rowData.put("unique_id", String.valueOf(rs.getLong("id")));

                rowData.put("income_sctn_cd", rs.getString("income_sctn_cd"));
                rowData.put("lsr_expndtr_totamt", rs.getDouble("lsr_expndtr_totamt"));
                rowData.put("lv_spl_expndtr_totamt", rs.getDouble("lv_spl_expndtr_totamt"));
                rowData.put("mcp_expndtr_totamt", rs.getDouble("mcp_expndtr_totamt"));
                rowData.put("mt_avrg_income_amt", rs.getDouble("mt_avrg_income_amt"));
                rowData.put("plesr_expndtr_totamt", rs.getDouble("plesr_expndtr_totamt"));
                rowData.put("stdr_yyqu_cd", rs.getString("stdr_yyqu_cd"));
                rowData.put("trdar_cd", rs.getString("trdar_cd"));
                rowData.put("trdar_cd_nm", rs.getString("trdar_cd_nm"));
                rowData.put("trdar_se_cd", rs.getString("trdar_se_cd"));
                rowData.put("trdar_se_cd_nm", rs.getString("trdar_se_cd_nm"));
                rowData.put("trnsport_expndtr_totamt", rs.getDouble("trnsport_expndtr_totamt"));

                // Weaviate 배치 처리
                batcher.withObject(WeaviateObject.builder()
                        .className("ExpenditureCommercialDistrict")
                        .properties(rowData)
                        .build());

                count++;

                // 배치 전송
                if (count % 100 == 0) {
                    batcher.run();
                    batcher = weaviateClient.batch().objectsBatcher();
                }
            }

            // 남은 데이터 처리
            if (count % 100 != 0) {
                batcher.run();
            }

            System.out.println("총 " + count + "개의 ExpenditureCommercialDistrict 데이터가 Weaviate에 업로드되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transferOfficetelValuationDataToWeaviate() {
        String query = "SELECT * FROM officetel_valuation LIMIT 10";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            ObjectsBatcher batcher = weaviateClient.batch().objectsBatcher();
            int count = 0;

            while (rs.next()) {
                Map<String, Object> rowData = new HashMap<>();

                // MySQL 데이터 읽어오기 및 변환
                rowData.put("unique_id", rs.getString("id"));  // id는 문자열로 처리
                rowData.put("건물층구분코드", rs.getString("건물층구분코드"));
                rowData.put("고시가격", rs.getObject("고시가격") != null ? Double.valueOf(rs.getString("고시가격")) : null);  // 고시가격은 숫자로 변환
                rowData.put("고시일자", rs.getString("고시일자"));
                rowData.put("공유면적", rs.getObject("공유면적") != null ? Double.valueOf(rs.getString("공유면적")) : null);  // 공유면적은 숫자로 변환
                rowData.put("번지", rs.getString("번지"));
                rowData.put("법정동코드", rs.getString("법정동코드"));
                rowData.put("상가건물동주소", rs.getString("상가건물동주소"));
                rowData.put("상가건물번호", rs.getString("상가건물번호"));
                rowData.put("상가건물블록주소", rs.getString("상가건물블록주소"));
                rowData.put("상가건물층주소", rs.getString("상가건물층주소"));
                rowData.put("상가건물호주소", rs.getString("상가건물호주소"));
                rowData.put("상가종류코드", rs.getString("상가종류코드"));
                rowData.put("전용면적", rs.getObject("전용면적") != null ? Double.valueOf(rs.getString("전용면적")) : null);  // 전용면적은 숫자로 변환
                rowData.put("특수지코드", rs.getString("특수지코드"));
                rowData.put("호", rs.getString("호"));

                // Weaviate에 데이터 추가
                batcher.withObject(WeaviateObject.builder()
                        .className("OfficetelValuation")
                        .properties(rowData)
                        .build());

                count++;

                // 10개마다 배치 실행
                if (count % 100 == 0) {
                    batcher.run();
                    batcher = weaviateClient.batch().objectsBatcher();
                }
            }

            // 남은 데이터가 있을 경우 처리
            if (count % 100 != 0) {
                batcher.run();
            }

            System.out.println("총 " + count + "개의 OfficetelValuation 데이터가 Weaviate에 업로드되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transferPassengerDataToWeaviate() {
        String query = "SELECT * FROM passenger LIMIT 10";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            ObjectsBatcher batcher = weaviateClient.batch().objectsBatcher();
            int count = 0;

            while (rs.next()) {
                Map<String, Object> rowData = new HashMap<>();

                // MySQL 데이터 읽어오기 (새로운 컬럼 이름을 반영)
                rowData.put("crtr_dd", rs.getString("crtr_dd"));  // 기준_날짜
                rowData.put("dong_id", rs.getString("dong_id"));  // 행정동_ID

                // int 타입 컬럼 처리
                rowData.put("psng_no", rs.getInt("psng_no"));  // 승객_수
                rowData.put("psng_no00", rs.getInt("psng_no00"));  // 승객_수_00시
                rowData.put("psng_no01", rs.getInt("psng_no01"));  // 승객_수_01시
                rowData.put("psng_no02", rs.getInt("psng_no02"));  // 승객_수_02시
                rowData.put("psng_no03", rs.getInt("psng_no03"));  // 승객_수_03시
                rowData.put("psng_no04", rs.getInt("psng_no04"));  // 승객_수_04시
                rowData.put("psng_no05", rs.getInt("psng_no05"));  // 승객_수_05시
                rowData.put("psng_no06", rs.getInt("psng_no06"));  // 승객_수_06시
                rowData.put("psng_no07", rs.getInt("psng_no07"));  // 승객_수_07시
                rowData.put("psng_no08", rs.getInt("psng_no08"));  // 승객_수_08시
                rowData.put("psng_no09", rs.getInt("psng_no09"));  // 승객_수_09시
                rowData.put("psng_no10", rs.getInt("psng_no10"));  // 승객_수_10시
                rowData.put("psng_no11", rs.getInt("psng_no11"));  // 승객_수_11시
                rowData.put("psng_no12", rs.getInt("psng_no12"));  // 승객_수_12시
                rowData.put("psng_no13", rs.getInt("psng_no13"));  // 승객_수_13시
                rowData.put("psng_no14", rs.getInt("psng_no14"));  // 승객_수_14시
                rowData.put("psng_no15", rs.getInt("psng_no15"));  // 승객_수_15시
                rowData.put("psng_no16", rs.getInt("psng_no16"));  // 승객_수_16시
                rowData.put("psng_no17", rs.getInt("psng_no17"));  // 승객_수_17시
                rowData.put("psng_no18", rs.getInt("psng_no18"));  // 승객_수_18시
                rowData.put("psng_no19", rs.getInt("psng_no19"));  // 승객_수_19시
                rowData.put("psng_no20", rs.getInt("psng_no20"));  // 승객_수_20시
                rowData.put("psng_no21", rs.getInt("psng_no21"));  // 승객_수_21시
                rowData.put("psng_no22", rs.getInt("psng_no22"));  // 승객_수_22시
                rowData.put("psng_no23", rs.getInt("psng_no23"));  // 승객_수_23시

                // Weaviate에 데이터 추가
                batcher.withObject(WeaviateObject.builder()
                        .className("Passenger")
                        .properties(rowData)
                        .build());

                count++;

                if (count % 100 == 0) {
                    batcher.run();  // 일정 갯수마다 배치 실행
                    batcher = weaviateClient.batch().objectsBatcher();  // 새로운 배치 생성
                }
            }

            // 남은 데이터 처리
            if (count % 100 != 0) {
                batcher.run();
            }

            System.out.println("총 " + count + "개의 Passenger 데이터가 Weaviate에 업로드되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transferPopulationDataToWeaviate() {
        String query = "SELECT * FROM population LIMIT 10";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            ObjectsBatcher batcher = weaviateClient.batch().objectsBatcher();
            int count = 0;

            while (rs.next()) {
                Map<String, Object> rowData = new HashMap<>();

                // MySQL 데이터 읽어오기 (컬럼 반영)
                rowData.put("adstrd_cd_nm", rs.getString("adstrd_cd_nm")); // string
                rowData.put("agrde10flpop_co", rs.getLong("agrde10flpop_co")); // number (bigint -> number)
                rowData.put("agrde20flpop_co", rs.getLong("agrde20flpop_co")); // number (bigint -> number)
                rowData.put("agrde30flpop_co", rs.getLong("agrde30flpop_co")); // number (bigint -> number)
                rowData.put("agrde40flpop_co", rs.getLong("agrde40flpop_co")); // number (bigint -> number)
                rowData.put("agrde50flpop_co", rs.getLong("agrde50flpop_co")); // number (bigint -> number)
                rowData.put("agrde60above_flpop_co", rs.getLong("agrde60above_flpop_co")); // number (bigint -> number)
                rowData.put("fml_flpop_co", rs.getLong("fml_flpop_co")); // number (bigint -> number)
                rowData.put("fri_flpop_co", rs.getLong("fri_flpop_co")); // number (bigint -> number)
                rowData.put("unique_id", rs.getLong("id")); // number (bigint -> number)
                rowData.put("ml_flpop_co", rs.getLong("ml_flpop_co")); // number (bigint -> number)
                rowData.put("mon_flpop_co", rs.getLong("mon_flpop_co")); // number (bigint -> number)
                rowData.put("sat_flpop_co", rs.getLong("sat_flpop_co")); // number (bigint -> number)
                rowData.put("stdr_yyqu_cd", rs.getString("stdr_yyqu_cd")); // string
                rowData.put("sun_flpop_co", rs.getLong("sun_flpop_co")); // number (bigint -> number)
                rowData.put("thur_flpop_co", rs.getLong("thur_flpop_co")); // number (bigint -> number)
                rowData.put("tmzon00_06flpop_co", rs.getLong("tmzon00_06flpop_co")); // number (bigint -> number)
                rowData.put("tmzon06_11flpop_co", rs.getLong("tmzon06_11flpop_co")); // number (bigint -> number)
                rowData.put("tmzon11_14flpop_co", rs.getLong("tmzon11_14flpop_co")); // number (bigint -> number)
                rowData.put("tmzon14_17flpop_co", rs.getLong("tmzon14_17flpop_co")); // number (bigint -> number)
                rowData.put("tmzon17_21flpop_co", rs.getLong("tmzon17_21flpop_co")); // number (bigint -> number)
                rowData.put("tmzon21_24flpop_co", rs.getLong("tmzon21_24flpop_co")); // number (bigint -> number)
                rowData.put("tot_flpop_co", rs.getLong("tot_flpop_co")); // number (bigint -> number)
                rowData.put("tues_flpop_co", rs.getLong("tues_flpop_co")); // number (bigint -> number)
                rowData.put("wed_flpop_co", rs.getLong("wed_flpop_co")); // number (bigint -> number)

                // Weaviate에 데이터 추가
                batcher.withObject(WeaviateObject.builder()
                        .className("Population")
                        .properties(rowData)
                        .build());

                count++;

                // 일정 수량마다 배치 전송
                if (count % 100 == 0) {
                    batcher.run();
                    batcher = weaviateClient.batch().objectsBatcher();
                }
            }

            // 남은 데이터 전송
            if (count % 100 != 0) {
                batcher.run();
            }

            System.out.println("총 " + count + "개의 Population 데이터가 Weaviate에 업로드되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void transferStoreDataToWeaviate() {
        String query = "SELECT * FROM store LIMIT 10";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            ObjectsBatcher batcher = weaviateClient.batch().objectsBatcher();
            int count = 0;

            while (rs.next()) {
                Map<String, Object> rowData = new HashMap<>();

                // MySQL 데이터 읽어오기 (형변환 적용)
                rowData.put("clsbiz_rt", rs.getDouble("clsbiz_rt"));  // double -> number
                rowData.put("opbiz_rt", rs.getDouble("opbiz_rt"));    // double -> number

                // 'bigint' -> 'int' 로 변경 (Long -> Integer)
                rowData.put("clsbiz_stor_co", rs.getInt("clsbiz_stor_co"));  // bigint -> int
                rowData.put("frc_stor_co", rs.getInt("frc_stor_co"));      // bigint -> int
                rowData.put("opbiz_stor_co", rs.getInt("opbiz_stor_co"));  // bigint -> int
                rowData.put("similr_induty_stor_co", rs.getInt("similr_induty_stor_co")); // bigint -> int
                rowData.put("stor_co", rs.getInt("stor_co")); // bigint -> int

                rowData.put("unique_id", rs.getInt("id"));  // id -> int (PK)

                rowData.put("stdr_yyqu_cd", rs.getString("stdr_yyqu_cd"));  // varchar -> string

                // 벡터화된 필드 처리
                rowData.put("svc_induty_cd", rs.getString("svc_induty_cd"));  // varchar -> string
                rowData.put("svc_induty_cd_nm", rs.getString("svc_induty_cd_nm"));  // varchar -> string
                rowData.put("trdar_cd_nm", rs.getString("trdar_cd_nm"));  // varchar -> string

                // 나머지 문자열 필드는 그대로 string으로 처리
                rowData.put("trdar_cd", rs.getString("trdar_cd"));  // varchar -> string
                rowData.put("trdar_se_cd", rs.getString("trdar_se_cd"));  // varchar -> string
                rowData.put("trdar_se_cd_nm", rs.getString("trdar_se_cd_nm"));  // varchar -> string

                System.out.println("Fetched Data: " + rowData);

                batcher.withObject(WeaviateObject.builder()
                        .className("Store")
                        .properties(rowData)
                        .build());

                count++;

                if (count % 100 == 0) {
                    batcher.run();
                    batcher = weaviateClient.batch().objectsBatcher();
                }
            }

            // 남은 데이터가 있으면 처리
            if (count % 100 != 0) {
                batcher.run();
            }

            System.out.println("총 " + count + "개의 Store 데이터가 Weaviate에 업로드되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
