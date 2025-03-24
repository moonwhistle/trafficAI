package com.example.backend.api.marketing.repository;

import com.example.backend.api.marketing.domain.EstimatedSales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstimatedSalesRepository extends JpaRepository<EstimatedSales, Long> {
}
