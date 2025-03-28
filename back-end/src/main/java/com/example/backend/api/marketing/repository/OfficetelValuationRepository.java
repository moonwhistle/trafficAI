package com.example.backend.api.marketing.repository;

import com.example.backend.api.marketing.domain.OfficetelValuation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficetelValuationRepository extends JpaRepository<OfficetelValuation, Long> {
}
