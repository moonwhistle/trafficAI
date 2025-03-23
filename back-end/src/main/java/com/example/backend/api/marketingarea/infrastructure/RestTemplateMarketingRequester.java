package com.example.backend.api.marketingarea.infrastructure;

import com.example.backend.api.marketingarea.constant.MarketingApiType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class RestTemplateMarketingRequester {

    private static final String MARKETING_BASE_URL = "http://openapi.seoul.go.kr:8088/";
    private static final int BATCH_SIZE = 5;

    private final RestTemplate restTemplate;

    private int getTotalCount(String apiKey, MarketingApiType apiType) {
        String url = MARKETING_BASE_URL + apiKey + "/json/" + apiType.getType() + "/1/1";
        String response = restTemplate.getForObject(url, String.class);

        try {
            JSONObject jsonResponse = new JSONObject(response);
            return jsonResponse.getJSONObject(apiType.getType()).getInt("list_total_count");
        } catch (Exception e) {
            log.info("총 데이터 값을 가져오지 못했습니다.");
            throw new RuntimeException(e);
        }
    }
}
