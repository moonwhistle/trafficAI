package com.example.backend.api.marketing.repository;

import com.example.backend.api.marketing.domain.Population;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopulationRepository extends JpaRepository<Population, Long> {
}
