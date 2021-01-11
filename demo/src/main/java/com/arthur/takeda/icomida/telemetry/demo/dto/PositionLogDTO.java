package com.arthur.takeda.icomida.telemetry.demo.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PositionLogDTO {

    private Long positionLogId;

    @NotNull(message = "Informe a latitude!")
    @Digits(fraction = 7, integer = 2)
    @DecimalMax("90")
    @DecimalMin("-90")
    private BigDecimal latitude;

    @NotNull(message = "Informe a longitude!")
    @Digits(fraction = 7, integer = 3)
    @DecimalMax("180")
    @DecimalMin("-180")
    private BigDecimal longitude;

    @NotNull(message = "Informe a bateria!")
    @DecimalMax("100")
    @DecimalMin("1")
    private Integer battery;

    @NotNull(message = "Informe o deliverymanId!")
    private Long deliverymanId;

    public PositionLogDTO(Long positionLogId, BigDecimal latitude, BigDecimal longitude, Integer battery, Boolean active, Long deliverymanId) {
        this.positionLogId = positionLogId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.battery = battery;
        this.deliverymanId = deliverymanId;

        this.latitude = this.latitude.setScale(9);
        this.longitude = this.longitude.setScale(10);
    }

    public PositionLogDTO() {
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

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) { this.battery = battery; }

    public Long getDeliverymanId() {
        return deliverymanId;
    }

    public void setDeliverymanId(Long deliverymanId) {
        this.deliverymanId = deliverymanId;
    }
}
