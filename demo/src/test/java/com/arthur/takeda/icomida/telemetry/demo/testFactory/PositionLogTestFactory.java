package com.arthur.takeda.icomida.telemetry.demo.testFactory;

import com.arthur.takeda.icomida.telemetry.demo.dto.PositionLogDTO;
import com.arthur.takeda.icomida.telemetry.demo.model.PositionLog;

import java.math.BigDecimal;

public class PositionLogTestFactory {

    public PositionLog positionLog(Long id){
        PositionLog positionLog = new PositionLog();

        positionLog.setPositionLogId(id);
        positionLog.setBattery(99);
        positionLog.setLatitude(new BigDecimal(34.7625659));
        positionLog.setLongitude(new BigDecimal(137.6329023));
        positionLog.setDeliverymanId(id);

        return positionLog;
    }

    public PositionLogDTO positionLogDTO(Long id){
        PositionLogDTO positionLogDTO = new PositionLogDTO();

        positionLogDTO.setPositionLogId(id);
        positionLogDTO.setBattery(99);
        positionLogDTO.setLatitude(new BigDecimal(34.7625659));
        positionLogDTO.setLongitude(new BigDecimal(137.6329023));
        positionLogDTO.setDeliverymanId(id);

        return positionLogDTO;
    }

}
