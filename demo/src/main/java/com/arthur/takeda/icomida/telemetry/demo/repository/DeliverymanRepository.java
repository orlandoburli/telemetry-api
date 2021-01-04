package com.arthur.takeda.icomida.telemetry.demo.repository;

import com.arthur.takeda.icomida.telemetry.demo.model.Deliveryman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeliverymanRepository extends JpaRepository<Deliveryman, Long> {

    public List<Deliveryman> findAllByActive(Boolean active);

    public Optional<Deliveryman> findByDeliverymanIdAndActive(Long deliverymanId, Boolean active);
}
