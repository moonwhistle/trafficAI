package com.example.backend.api.marketing.infrastructure;

import com.example.backend.api.marketing.constant.MarketingApiType;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class RestTemplateMarketingRequester {

    private static final String MARKETING_BASE_URL = "http://openapi.seoul.go.kr:8088/";
    private static final int BATCH_SIZE = 5;
    private static final int INDEX_START = 1;

    private final RestTemplate restTemplate;

    public List<String> requestMarketingData(String apiKey, MarketingApiType apiType) {
        int totalCount = getTotalCount(apiKey, apiType);
        List<String> allData = new ArrayList<>();

        for (int start = INDEX_START; start <= 5; start += BATCH_SIZE) {
            int end = Math.min(start + BATCH_SIZE - 1, totalCount);
            String url = MARKETING_BASE_URL + apiKey + "/json/" + apiType.getType() + "/" + start + "/" + end;
            String response = getData(url);
            allData.add(response);
        }

        return allData;
    }

    private String getData(String url) {
        RequestEntity<Void> requestEntity = RequestEntity.get(URI.create(url))
                .accept(MediaType.APPLICATION_JSON)
                .build();

        return restTemplate.exchange(requestEntity, String.class)
                .getBody();
    }

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
