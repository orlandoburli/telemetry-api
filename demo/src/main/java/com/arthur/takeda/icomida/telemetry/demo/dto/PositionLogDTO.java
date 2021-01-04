package com.arthur.takeda.icomida.telemetry.demo.dto;

import com.arthur.takeda.icomida.telemetry.demo.model.Deliveryman;

import javax.persistence.*;

public class PositionLogDTO {

    private Long positionLogId;

    private Double latitude;

    private Double longitude;

    private Double battery;

    private Long deliverymanId;

    public PositionLogDTO(Long positionLogId, Double latitude, Double longitude, Double battery, Boolean active, Long deliverymanId) {
        this.positionLogId = positionLogId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.battery = battery;
        this.deliverymanId = deliverymanId;
    }

    public PositionLogDTO() {
    }

    public Long getPositionLogId() {
        return positionLogId;
    }

    public void setPositionLogId(Long positionLogId) {
        this.positionLogId = positionLogId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getBattery() {
        return battery;
    }

    public void setBattery(Double battery) {
        this.battery = battery;
    }

    public Long getDeliverymanId() {
        return deliverymanId;
    }

    public void setDeliverymanId(Long deliverymanId) {
        this.deliverymanId = deliverymanId;
    }
}
