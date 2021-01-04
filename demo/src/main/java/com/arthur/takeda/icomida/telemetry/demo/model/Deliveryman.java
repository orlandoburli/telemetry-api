package com.arthur.takeda.icomida.telemetry.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
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

    private Boolean active;

    public Deliveryman(Long deliverymanId, String cpf, String name, String status, String batteryStatus) {
        this.deliverymanId = deliverymanId;
        this.cpf = cpf;
        this.name = name;
        this.status = status;
        this.batteryStatus = batteryStatus;
        this.active = true;
    }

    public Deliveryman(){
        this.active = true;
    }

    public Long getDeliverymanId() {
        return deliverymanId;
    }

    public void setDeliverymanId(Long deliverymanId) {
        this.deliverymanId = deliverymanId;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(String batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    public void setActive(Boolean active){
        this.active = active;
    }

    public Boolean getActive() {
        return active;
    }
}