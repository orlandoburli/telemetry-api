package com.arthur.takeda.icomida.telemetry.demo.model;

import javax.persistence.*;

@Entity(name = "position_log")
public class PositionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_log_id")
    private Long positionLogId;

    private Double latitude;

    private Double longitude;

    private Double battery;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "deliveryman_id")
    private Deliveryman deliveryman;

    public PositionLog(Long positionLogId, Double latitude, Double longitude, Double battery, Deliveryman deliveryman) {
        this.positionLogId = positionLogId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.battery = battery;
        this.active = Boolean.TRUE;
        this.deliveryman = deliveryman;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Deliveryman getDeliveryman() {
        return deliveryman;
    }

    public void setDeliveryman(Deliveryman deliveryman) {
        this.deliveryman = deliveryman;
    }
}
