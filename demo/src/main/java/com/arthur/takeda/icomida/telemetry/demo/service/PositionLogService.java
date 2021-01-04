package com.arthur.takeda.icomida.telemetry.demo.service;

import com.arthur.takeda.icomida.telemetry.demo.dto.DeliverymanDTO;
import com.arthur.takeda.icomida.telemetry.demo.dto.PositionLogDTO;
import com.arthur.takeda.icomida.telemetry.demo.dto.mapper.PositionLogMapper;
import com.arthur.takeda.icomida.telemetry.demo.exception.NotFoundException;
import com.arthur.takeda.icomida.telemetry.demo.model.Deliveryman;
import com.arthur.takeda.icomida.telemetry.demo.model.PositionLog;
import com.arthur.takeda.icomida.telemetry.demo.repository.PositionLogRepository;
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
    private DeliverymanService deliverymanService;

    @Autowired
    private PositionLogMapper mapper;

    public PositionLogDTO findById(Long id) throws NotFoundException{
        Optional<PositionLog> positionLogOptional = positionLogRepository.findByPositionLogIdAndActive(id, Boolean.TRUE);

        if(positionLogOptional.isEmpty()){
            throw new NotFoundException("PositionLog not found");
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

        System.out.println(positionLogRepository.findByDeliverymanAndActiveAndLast(positionLogDTO.getDeliverymanId(), Boolean.TRUE).get().getPositionLogId());

        positionLogRepository.save(positionLog);

        return positionLog.getPositionLogId();
    }

    public Long save(PositionLogDTO positionLogDTO, Long id) throws NotFoundException {
        Optional<PositionLog> positionLog = positionLogRepository.findByPositionLogIdAndActive(id, Boolean.TRUE);

        if(positionLog.isEmpty()){
            throw new NotFoundException("PositionLog not found");
        }

        positionLogDTO.setPositionLogId(id);

        positionLogRepository.save(mapper.toPositionLog(positionLogDTO));

        return id;
    }

    @Transactional
    public void delete(Long id) throws NotFoundException{
        Optional<PositionLog> positionLogOptional = positionLogRepository.findByPositionLogIdAndActive(id, Boolean.TRUE);
        PositionLog positionLog;

        if(positionLogOptional.isEmpty()){
            throw new NotFoundException("PositionLog not found");
        }

        positionLog = positionLogOptional.get();

        positionLog.setActive(Boolean.FALSE);
    }

}
