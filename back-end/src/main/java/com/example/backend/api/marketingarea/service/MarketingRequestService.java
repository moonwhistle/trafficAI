package com.example.backend.api.marketingarea.service;

import com.example.backend.api.marketingarea.constant.MarketingApiType;
import com.example.backend.api.marketingarea.domain.ExpenditureArea;
import com.example.backend.api.marketingarea.domain.ExpenditureCommercialDistrict;
import com.example.backend.api.marketingarea.repository.ExpenditureAreaRepository;
import com.example.backend.api.marketingarea.repository.ExpenditureCommercialDistrictRepository;
import com.example.backend.api.marketingarea.service.dto.AreaRequest;
import com.example.backend.api.marketingarea.service.dto.CommercialDistrictRequest;
import com.example.backend.api.marketingarea.service.fetcher.MarketingFetcher;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    private final ExpenditureAreaRepository expenditureAreaRepository;

    @Value("${INCOME.CONSUMPTION.MARKETING.AREA.API.KEY}")
    private String INCOME_CONSUMPTION_API_KEY;

    @Value("${BOROUGH.API.KEY}")
    private String BOROUGH_API_KEY;

    public void saveExpenditureDistrict() {
        List<ExpenditureArea> districts = makeExpenditureAreasByDistricts();
        Set<String> existingSignguCdNms = new HashSet<>(expenditureAreaRepository.findAllSignguCdNms());

        for (ExpenditureArea area : districts) {
            if (!existingSignguCdNms.contains(area.getSignguCdNm())) {
                expenditureAreaRepository.save(area);
                existingSignguCdNms.add(area.getSignguCdNm());
            }
        }
    }

    private List<ExpenditureArea> makeExpenditureAreasByDistricts() {
        List<AreaRequest> requests = marketingFetcher.fetchAndParseData(
                BOROUGH_API_KEY,
                MarketingApiType.INCOME_CONSUMPTION_DISTRICT,
                AreaRequest.class
        );

        return requests.stream()
                .map(AreaRequest::toExpenditureArea)
                .toList();
    }

    public void saveExpenditureCommercialDistrict() {
        List<ExpenditureCommercialDistrict> districts = makeCommercialDistricts();
        Set<String> existingTrdarCdNm = new HashSet<>(expenditureCommercialDistrictRepository.findAlltrdarCdNm());

        for (ExpenditureCommercialDistrict commercialDistrict : districts) {
            if (!existingTrdarCdNm.contains(commercialDistrict.getTrdarCdNm())) {
                expenditureCommercialDistrictRepository.save(commercialDistrict);
                existingTrdarCdNm.add(commercialDistrict.getTrdarCdNm());
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
