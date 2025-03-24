package com.example.backend.api.marketingarea.repository;

import com.example.backend.api.marketingarea.domain.ExpenditureArea;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExpenditureAreaRepository extends JpaRepository<ExpenditureArea, Long> {

    @Query("SELECT e.signguCdNm FROM ExpenditureArea e")
    List<String> findAllSignguCdNms();
}
