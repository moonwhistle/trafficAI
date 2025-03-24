package com.example.backend.api.marketing.repository;

import com.example.backend.api.marketing.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
