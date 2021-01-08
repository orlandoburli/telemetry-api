package com.arthur.takeda.icomida.telemetry.demo.service;

import com.arthur.takeda.icomida.telemetry.demo.dto.PositionLogDTO;
import com.arthur.takeda.icomida.telemetry.demo.dto.mapper.PositionLogMapper;
import com.arthur.takeda.icomida.telemetry.demo.model.PositionLog;
import com.arthur.takeda.icomida.telemetry.demo.repository.PositionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionLogService {

    @Autowired
    private PositionLogRepository positionLogRepository;

    @Autowired
    private PositionLogMapper mapper;

    public Long save(PositionLogDTO positionLogDTO){
        PositionLog positionLog = mapper.toPositionLog(positionLogDTO);

        positionLogRepository.save(positionLog);

        return positionLog.getPositionLogId();
    }
}
