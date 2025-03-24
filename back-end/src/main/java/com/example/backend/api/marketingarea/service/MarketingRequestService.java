package com.example.backend.api.marketingarea.service;

import com.example.backend.api.marketingarea.constant.MarketingApiType;
import com.example.backend.api.marketingarea.domain.ExpenditureCommercialDistrict;
import com.example.backend.api.marketingarea.repository.ExpenditureCommercialDistrictRepository;
import com.example.backend.api.marketingarea.service.dto.CommercialDistrictRequest;
import com.example.backend.api.marketingarea.service.fetcher.MarketingFetcher;
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
        for(ExpenditureCommercialDistrict commercialDistrict : districts) {
            if(!expenditureCommercialDistrictRepository.existsByTrdarCdNm(commercialDistrict.getTrdarCdNm())) {
                expenditureCommercialDistrictRepository.save(commercialDistrict);
            }
        }
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
