package com.arthur.takeda.icomida.telemetry.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity(name = "position_log")
public class PositionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_log_id")
    private Long positionLogId;

    @Column(length = 9, precision = 7, nullable = false)
    private BigDecimal latitude;

    @Column(length = 10, precision = 7, nullable = false)
    private BigDecimal longitude;

    private Integer battery;

    private Boolean active;

    private Long deliverymanId;

    public PositionLog(Long positionLogId, BigDecimal latitude, BigDecimal longitude, Integer battery, Long deliverymanId) {
        this.positionLogId = positionLogId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.battery = battery;
        this.active = Boolean.TRUE;
        this.deliverymanId = deliverymanId;
    }

    public PositionLog() {
        this.active = Boolean.TRUE;
    }

    public Long getPositionLogId() {
        return positionLogId;
    }

    public void setPositionLogId(Long positionLogId) {
        this.positionLogId = positionLogId;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) { this.latitude = latitude; }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getDeliverymanId() {
        return deliverymanId;
    }

    public void setDeliverymanId(Long deliverymanId) {
        this.deliverymanId = deliverymanId;
    }
}
