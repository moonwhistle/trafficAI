package com.example.backend.api.marketing.service.fetcher;

import com.example.backend.api.marketing.constant.MarketingApiType;
import com.example.backend.api.marketing.infrastructure.RestTemplateMarketingRequester;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MarketingFetcher {

    private final RestTemplateMarketingRequester requester;

    public <T> List<T> fetchAndParseData(String apiKey, MarketingApiType apiType, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            List<String> data = requester.requestMarketingData(apiKey, apiType);

            for (String json : data) {
                JsonNode jsonNode = mapper.readTree(json);
                JsonNode rows = jsonNode.path(apiType.getType()).path("row");

                List<T> parsedData = mapper.readValue(
                        rows.toString(),
                        mapper.getTypeFactory().constructCollectionType(List.class, clazz)
                );
                result.addAll(parsedData);
            }
        } catch (IOException e) {

            log.info("객체 변환 중 오류 발생");
            throw new RuntimeException(e);
        }

        return result;
    }

    public <T> List<T> fetchAndParseOfficetelData(String apiKey, MarketingApiType apiType, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            // API에서 데이터 가져오기
            List<String> data = requester.requestOfficetelData(apiKey, apiType);

            for (String json : data) {
                // UTF-8로 인코딩된 데이터 처리
                byte[] bytes = json.getBytes(StandardCharsets.UTF_8);  // JSON 문자열을 UTF-8 바이트 배열로 변환
                String utf8Json = new String(bytes, StandardCharsets.UTF_8);  // UTF-8로 다시 문자열로 변환

                // UTF-8로 변환된 문자열을 JsonNode로 파싱
                JsonNode jsonNode = mapper.readTree(utf8Json);
                JsonNode dataNode = jsonNode.path("data");  // "data" 노드에 접근

                if (dataNode.isArray()) {
                    // "data" 배열을 순회하며 각 항목을 T 타입으로 파싱
                    List<T> parsedData = mapper.readValue(
                            dataNode.toString(),  // 배열을 JSON 문자열로 변환
                            mapper.getTypeFactory().constructCollectionType(List.class, clazz)
                    );
                    result.addAll(parsedData);  // 파싱한 데이터를 결과 리스트에 추가
                }
                System.out.println(result);
            }
        } catch (IOException e) {
            log.error("객체 변환 중 오류 발생: {}", e.getMessage(), e);
            throw new RuntimeException("데이터 파싱 실패", e);
        }

        return result;
    }
}
