package org.DRTCT.repository;

import org.DRTCT.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
    boolean existsByCode(String code);
}
