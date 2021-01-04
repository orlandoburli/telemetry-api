package com.arthur.takeda.icomida.telemetry.demo.service;

import com.arthur.takeda.icomida.telemetry.demo.dto.DeliverymanDTO;
import com.arthur.takeda.icomida.telemetry.demo.dto.PositionLogDTO;
import com.arthur.takeda.icomida.telemetry.demo.dto.mapper.PositionLogMapper;
import com.arthur.takeda.icomida.telemetry.demo.model.Deliveryman;
import com.arthur.takeda.icomida.telemetry.demo.model.PositionLog;
import com.arthur.takeda.icomida.telemetry.demo.repository.PositionLogRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PositionLogService {

    @Autowired
    private PositionLogRepository positionLogRepository;

    @Autowired
    private PositionLogMapper mapper;

    public PositionLogDTO findById(Long id){
        Optional<PositionLog> positionLogOptional = positionLogRepository.findByPositionLogIdAndActive(id, Boolean.TRUE);

        if(positionLogOptional.isEmpty()){
            return new PositionLogDTO();
        }

        return mapper.toPositionLogDto(positionLogOptional.get());
    }

    public List<PositionLogDTO> findAll(){
        List<PositionLog> positionLogList  = positionLogRepository.findAllByActive(Boolean.TRUE);

        return positionLogList
                .parallelStream()
                .map(mapper::toPositionLogDto)
                .collect(Collectors.toList());
    }

    public Long save(PositionLogDTO positionLogDTO){
        PositionLog positionLog = mapper.toPositionLog(positionLogDTO);

        positionLogRepository.save(positionLog);

        return positionLog.getPositionLogId();
    }

    public Long save(PositionLogDTO positionLogDTO, Long id) throws Exception {
        Optional<PositionLog> positionLog = positionLogRepository.findByPositionLogIdAndActive(id, Boolean.TRUE);

        if(positionLog.isEmpty()){
            throw new Exception("PositionLog not found");
        }

        positionLogDTO.setPositionLogId(id);

        positionLogRepository.save(mapper.toPositionLog(positionLogDTO));

        return id;
    }

    @Transactional
    public void delete(Long id) throws Exception{
        Optional<PositionLog> positionLogOptional = positionLogRepository.findByPositionLogIdAndActive(id, Boolean.TRUE);
        PositionLog positionLog;

        if(positionLogOptional.isEmpty()){
            throw new Exception("Deliveryman not found");
        }

        positionLog = positionLogOptional.get();

        positionLog.setActive(Boolean.FALSE);
    }

}
