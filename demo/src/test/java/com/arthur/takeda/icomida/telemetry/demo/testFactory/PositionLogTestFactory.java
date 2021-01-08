package com.arthur.takeda.icomida.telemetry.demo.testFactory;

import com.arthur.takeda.icomida.telemetry.demo.dto.PositionLogDTO;
import com.arthur.takeda.icomida.telemetry.demo.model.PositionLog;
import com.github.javafaker.Faker;

import java.math.BigDecimal;
import java.util.Locale;

public class PositionLogTestFactory {

    public Faker faker = new Faker(new Locale("pt", "BR"));

    public PositionLog positionLog(Long id){
        PositionLog positionLog = new PositionLog();

        positionLog.setPositionLogId(id);
        positionLog.setBattery(faker.number().numberBetween(1, 100));
        positionLog.setLatitude(new BigDecimal("34.7625659"));
        positionLog.setLongitude(new BigDecimal("137.6329023"));
        positionLog.setDeliverymanId(faker.number().randomNumber());

        System.out.println(positionLog.getDeliverymanId());

        return positionLog;
    }

    public PositionLogDTO positionLogDTO(Long id){
        PositionLogDTO positionLogDTO = new PositionLogDTO();

        positionLogDTO.setPositionLogId(id);
        positionLogDTO.setBattery(99);
        positionLogDTO.setLatitude(new BigDecimal("34.7625659"));
        positionLogDTO.setLongitude(new BigDecimal("137.6329023"));
        positionLogDTO.setDeliverymanId(id);

        return positionLogDTO;
    }

}
