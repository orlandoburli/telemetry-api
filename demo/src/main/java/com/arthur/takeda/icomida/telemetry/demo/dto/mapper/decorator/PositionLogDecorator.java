package com.arthur.takeda.icomida.telemetry.demo.dto.mapper.decorator;

import com.arthur.takeda.icomida.telemetry.demo.dto.DeliverymanDTO;
import com.arthur.takeda.icomida.telemetry.demo.dto.PositionLogDTO;
import com.arthur.takeda.icomida.telemetry.demo.dto.mapper.DeliverymanMapper;
import com.arthur.takeda.icomida.telemetry.demo.dto.mapper.PositionLogMapper;
import com.arthur.takeda.icomida.telemetry.demo.model.PositionLog;
import com.arthur.takeda.icomida.telemetry.demo.service.DeliverymanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class PositionLogDecorator implements PositionLogMapper {

    @Autowired
    DeliverymanService deliverymanService;

    @Autowired
    DeliverymanMapper deliverymanMapper;

    @Autowired
    @Qualifier("delegate")
    private PositionLogMapper delegate;

    @Override
    public PositionLog toPositionLog(PositionLogDTO positionLogDTO){
        PositionLog positionLog = delegate.toPositionLog(positionLogDTO);

        DeliverymanDTO deliverymanDTO = deliverymanService.findById(positionLogDTO.getDeliverymanId());

        positionLog.setDeliveryman(deliverymanMapper.toDeliveryman(deliverymanDTO));

        return positionLog;
    }

    @Override
    public PositionLogDTO toPositionLogDto(PositionLog positionLog) {
        PositionLogDTO positionLogDTO = delegate.toPositionLogDto(positionLog);

        positionLogDTO.setDeliverymanId(positionLog.getDeliveryman().getDeliverymanId());

        return positionLogDTO;
    }
}
