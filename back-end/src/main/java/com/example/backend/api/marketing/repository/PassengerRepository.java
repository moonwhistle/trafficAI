package com.example.backend.api.marketing.repository;

import com.example.backend.api.marketing.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    List<Passenger> findTop5ByOrderByCrtrDdAsc();
}
