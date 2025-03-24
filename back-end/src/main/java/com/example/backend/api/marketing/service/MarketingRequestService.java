package com.example.backend.api.marketing.service;

import com.example.backend.api.marketing.constant.MarketingApiType;
import com.example.backend.api.marketing.domain.EstimatedSales;
import com.example.backend.api.marketing.domain.ExpenditureCommercialDistrict;
import com.example.backend.api.marketing.domain.Passenger;
import com.example.backend.api.marketing.domain.Population;
import com.example.backend.api.marketing.domain.Store;
import com.example.backend.api.marketing.repository.EstimatedSalesRepository;
import com.example.backend.api.marketing.repository.ExpenditureCommercialDistrictRepository;
import com.example.backend.api.marketing.repository.PassengerRepository;
import com.example.backend.api.marketing.repository.PopulationRepository;
import com.example.backend.api.marketing.repository.StoreRepository;
import com.example.backend.api.marketing.service.dto.CommercialDistrictRequest;
import com.example.backend.api.marketing.service.dto.EstimatedSalesRequest;
import com.example.backend.api.marketing.service.dto.PassengerRequest;
import com.example.backend.api.marketing.service.dto.PopulationRequest;
import com.example.backend.api.marketing.service.dto.StoreRequest;
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
    private final StoreRepository storeRepository;
    private final PopulationRepository populationRepository;
    private final EstimatedSalesRepository estimatedSalesRepository;
    private final PassengerRepository passengerRepository;

    @Value("${INCOME.CONSUMPTION.MARKETING.AREA.API.KEY}")
    private String INCOME_CONSUMPTION_API_KEY;

    @Value("${STORE_API_KEY}")
    private String STORE_API_KEY;

    @Value("${POPULATION.API.KEY}")
    private String POPULATION_API_KEY;

    @Value("${ESTIMATED_SALES_API_KEY}")
    private String ESTIMATED_SALES_API_KEY;

    @Value("${PASSENGER_API_KEY}")
    private String PASSENGER_API_KEY;

    public void savePassengers() {
        List<Passenger> passengers = makePassengers();
        passengerRepository.saveAll(passengers);
    }

    private List<Passenger> makePassengers() {
        List<PassengerRequest> requests = marketingFetcher.fetchAndParseData(
                PASSENGER_API_KEY,
                MarketingApiType.PASSENGER_MARKETING_AREA,
                PassengerRequest.class
        );

        return requests.stream()
                .map(PassengerRequest::toPassenger)
                .toList();
    }

    public void saveEstimatedSales() {
        List<EstimatedSales> estimatedSales = makeEstimatedSales();
        estimatedSalesRepository.saveAll(estimatedSales);
    }

    private List<EstimatedSales> makeEstimatedSales() {
        List<EstimatedSalesRequest> requests = marketingFetcher.fetchAndParseData(
                ESTIMATED_SALES_API_KEY,
                MarketingApiType.ESTIMATED_SALES_MARKETING_AREA,
                EstimatedSalesRequest.class
        );

        return requests.stream()
                .map(EstimatedSalesRequest::toEstimatedSales)
                .toList();
    }

    public void savePopulations() {
        List<Population> populations = makePopulations();
        populationRepository.saveAll(populations);
    }

    private List<Population> makePopulations() {
        List<PopulationRequest> requests = marketingFetcher.fetchAndParseData(
                POPULATION_API_KEY,
                MarketingApiType.ROAD_UNIT_POPULATION_ADMINISTRATIVE_DONG,
                PopulationRequest.class
        );

        return requests.stream()
                .map(PopulationRequest::toPopulation)
                .toList();
    }

    public void saveStores() {
        List<Store> stores = makeStores();
        storeRepository.saveAll(stores);
    }

    private List<Store> makeStores() {
        List<StoreRequest> requests = marketingFetcher.fetchAndParseData(
                STORE_API_KEY,
                MarketingApiType.STORE_MARKETING_AREA,
                StoreRequest.class
        );

        return requests.stream()
                .map(StoreRequest::toStore)
                .toList();
    }

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
