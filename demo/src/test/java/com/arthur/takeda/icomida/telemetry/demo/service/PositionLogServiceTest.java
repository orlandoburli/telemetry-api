package com.arthur.takeda.icomida.telemetry.demo.service;

import com.arthur.takeda.icomida.telemetry.demo.dto.PositionLogDTO;
import com.arthur.takeda.icomida.telemetry.demo.dto.mapper.PositionLogMapper;
import com.arthur.takeda.icomida.telemetry.demo.exception.NotFoundException;
import com.arthur.takeda.icomida.telemetry.demo.model.PositionLog;
import com.arthur.takeda.icomida.telemetry.demo.repository.PositionLogRepository;
import com.arthur.takeda.icomida.telemetry.demo.testFactory.PositionLogTestFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PositionLogServiceTest {

    @Mock
    private PositionLogMapper mapper;

    @Mock
    private PositionLogRepository positionLogRepository;

    @InjectMocks
    private PositionLogService positionLogService;

    private PositionLogTestFactory positionLogTestFactory = new PositionLogTestFactory();

    @Test
    public void testSavePositionLog(){
        Long id = 1l;

        PositionLog positionLog = positionLogTestFactory.positionLog(id);
        PositionLogDTO positionLogDTO = positionLogTestFactory.positionLogDTO(id);

        Mockito.when(mapper.toPositionLog(positionLogDTO)).thenReturn(positionLog);
        Mockito.when(positionLogRepository.save(positionLog)).thenReturn(positionLog);

        Assertions.assertEquals(id, positionLogService.save(positionLogDTO));
    }

    private void compare(PositionLogDTO expected, PositionLogDTO actual){
        Assertions.assertAll(
                () -> Assertions.assertEquals(expected.getPositionLogId(), actual.getPositionLogId()),
                () -> Assertions.assertEquals(expected.getBattery(), actual.getBattery()),
                () -> Assertions.assertEquals(expected.getDeliverymanId(), actual.getDeliverymanId()),
                () -> Assertions.assertEquals(expected.getLatitude(), actual.getLatitude()),
                () -> Assertions.assertEquals(expected.getLongitude(), actual.getLongitude())
                );
    }
}