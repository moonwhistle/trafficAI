package com.example.backend.api.marketing.repository;

import com.example.backend.api.marketing.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
