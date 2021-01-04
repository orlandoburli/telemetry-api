package com.arthur.takeda.icomida.telemetry.demo.repository;

import com.arthur.takeda.icomida.telemetry.demo.model.PositionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PositionLogRepository extends JpaRepository<PositionLog, Long> {

    public List<PositionLog> findAllByActive(Boolean active);

    public Optional<PositionLog> findByPositionLogIdAndActive(Long positionLogId, Boolean active);

    @Query(value = "SELECT * FROM position_log WHERE active = ?2 AND" +
            " deliveryman_id = ?1 " +
            " ORDER BY position_log_id DESC LIMIT 1", nativeQuery = true)
    public Optional<PositionLog> findByDeliverymanAndActiveAndLast(Long deliveryman_id, Boolean active);
}
