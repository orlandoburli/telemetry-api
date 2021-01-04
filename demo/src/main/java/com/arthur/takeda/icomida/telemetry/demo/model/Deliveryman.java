package com.arthur.takeda.icomida.telemetry.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deliveryman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deliveryman_id")
    private Long deliverymanId;

    private String cpf;

    private String name;

    private String status;

    @Column(name = "battery_status")
    private String batteryStatus;
}
