package com.arthur.takeda.icomida.telemetry.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class DeliverymanDTO {

    private Long deliverymanId;
    private String name;
    private String cpf;
    private String status;
    private String batteryStatus;

    public DeliverymanDTO(Long deliverymanId, String name, String cpf, String status, String batteryStatus) {
        this.deliverymanId = deliverymanId;
        this.name = name;
        this.cpf = cpf;
        this.status = status;
        this.batteryStatus = batteryStatus;
    }

    public DeliverymanDTO() {
    }

    public Long getDeliverymanId() {
        return deliverymanId;
    }

    public void setDeliverymanId(Long deliverymanId) {
        this.deliverymanId = deliverymanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
}
