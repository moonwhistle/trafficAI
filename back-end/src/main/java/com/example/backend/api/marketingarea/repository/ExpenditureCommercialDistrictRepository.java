package com.example.backend.api.marketingarea.repository;

import com.example.backend.api.marketingarea.domain.ExpenditureCommercialDistrict;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExpenditureCommercialDistrictRepository extends JpaRepository<ExpenditureCommercialDistrict, Long> {

    @Query("SELECT e.trdarCdNm FROM ExpenditureCommercialDistrict e")
    List<String> findAlltrdarCdNm();
}
