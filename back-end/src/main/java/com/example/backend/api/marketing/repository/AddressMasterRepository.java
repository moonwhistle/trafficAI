package com.example.backend.api.marketing.repository;

import com.example.backend.api.marketing.domain.AddressMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressMasterRepository extends JpaRepository<AddressMaster, String> {
}
