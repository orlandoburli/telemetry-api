package com.arthur.takeda.icomida.telemetry.demo.testFactory;

import com.arthur.takeda.icomida.telemetry.demo.dto.DeliverymanDTO;
import com.arthur.takeda.icomida.telemetry.demo.dto.PositionLogDTO;
import com.arthur.takeda.icomida.telemetry.demo.model.Deliveryman;
import com.arthur.takeda.icomida.telemetry.demo.model.PositionLog;

public class PositionLogTestFactory {

    public PositionLog positionLog(Long id){
        PositionLog positionLog = new PositionLog();

        positionLog.setPositionLogId(id);
        positionLog.setBattery(99d);
        positionLog.setLatitude(34.7625659d);
        positionLog.setLongitude(137.6329023d);
        positionLog.setDeliveryman(new DeliverymanTestFactory().deliveryman(id));

        return positionLog;
    }

    public PositionLogDTO positionLogDTO(Long id){
        PositionLogDTO positionLogDTO = new PositionLogDTO();

        positionLogDTO.setPositionLogId(id);
        positionLogDTO.setBattery(99d);
        positionLogDTO.setLatitude(34.7625659d);
        positionLogDTO.setLongitude(137.6329023d);
        positionLogDTO.setDeliverymanId(id);

        return positionLogDTO;
    }

}
