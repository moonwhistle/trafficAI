package com.example.backend.api.marketingarea.service.fetcher;

import com.example.backend.api.marketingarea.constant.MarketingApiType;
import com.example.backend.api.marketingarea.infrastructure.RestTemplateMarketingRequester;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
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
}
