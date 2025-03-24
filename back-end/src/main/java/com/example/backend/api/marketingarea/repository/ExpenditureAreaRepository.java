package com.example.backend.api.marketingarea.repository;

import com.example.backend.api.marketingarea.domain.ExpenditureArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenditureAreaRepository extends JpaRepository<ExpenditureArea, Long> {

    boolean existsBySignguCdNm(String signguCdNm);
}
