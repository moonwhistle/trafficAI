package com.example.backend.api.marketing.service;

import com.example.backend.api.marketing.constant.MarketingApiType;
import com.example.backend.api.marketing.domain.ExpenditureCommercialDistrict;
import com.example.backend.api.marketing.repository.ExpenditureCommercialDistrictRepository;
import com.example.backend.api.marketing.service.dto.CommercialDistrictRequest;
import com.example.backend.api.marketing.service.fetcher.MarketingFetcher;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MarketingRequestService {

    private final MarketingFetcher marketingFetcher;
    private final ExpenditureCommercialDistrictRepository expenditureCommercialDistrictRepository;

    @Value("${INCOME.CONSUMPTION.MARKETING.AREA.API.KEY}")
    private String INCOME_CONSUMPTION_API_KEY;

    public void saveExpenditureCommercialDistrict() {
        List<ExpenditureCommercialDistrict> districts = makeCommercialDistricts();
        expenditureCommercialDistrictRepository.saveAll(districts);
    }

    private List<ExpenditureCommercialDistrict> makeCommercialDistricts() {
        List<CommercialDistrictRequest> requests = marketingFetcher.fetchAndParseData(
                INCOME_CONSUMPTION_API_KEY,
                MarketingApiType.INCOME_CONSUMPTION_MARKETING_AREA,
                CommercialDistrictRequest.class
        );

        return requests.stream()
                .map(CommercialDistrictRequest::toCommercialDistrict)
                .toList();
    }
}
