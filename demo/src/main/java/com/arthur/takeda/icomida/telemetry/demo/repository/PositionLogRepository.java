package com.arthur.takeda.icomida.telemetry.demo.repository;

import com.arthur.takeda.icomida.telemetry.demo.model.PositionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PositionLogRepository extends JpaRepository<PositionLog, Long> {

    public List<PositionLog> findAllByActive(Boolean active);

    public Optional<PositionLog> findByPositionLogIdAndActive(Long positionLogId, Boolean active);

}
