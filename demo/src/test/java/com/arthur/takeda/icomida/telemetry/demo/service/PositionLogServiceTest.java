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

import java.util.List;
import java.util.Optional;

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
    public void testGetPositionLogExisting(){
        Long id = 1l;

        PositionLog positionLog = positionLogTestFactory.positionLog(id);
        PositionLogDTO positionLogDTO = positionLogTestFactory.positionLogDTO(id);

        Mockito.when(positionLogRepository.findByPositionLogIdAndActive(id, Boolean.TRUE)).thenReturn(Optional.of(positionLog));
        Mockito.when(mapper.toPositionLogDto(positionLog)).thenReturn(positionLogDTO);

        compare(positionLogDTO, positionLogService.findById(id));
    }

    @Test
    public void testGetPositionLogAbsent(){
        Long id = 1l;

        Mockito.when(positionLogRepository.findByPositionLogIdAndActive(id, Boolean.TRUE)).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, () -> positionLogService.findById(id));
    }

    @Test
    public void testGetAllPositionLog(){
        Long id = 1l;

        List<PositionLog> positionLogList = List.of(positionLogTestFactory.positionLog(id), positionLogTestFactory.positionLog(id + 1));
        List<PositionLogDTO> positionLogDTOList = List.of(positionLogTestFactory.positionLogDTO(id), positionLogTestFactory.positionLogDTO(id + 1));

        Mockito.when(positionLogRepository.findAllByActive(Boolean.TRUE)).thenReturn(positionLogList);
        Mockito.when(mapper.toPositionLogDto(positionLogList.get(0))).thenReturn(positionLogDTOList.get(0));
        Mockito.when(mapper.toPositionLogDto(positionLogList.get(1))).thenReturn(positionLogDTOList.get(1));

        List<PositionLogDTO> result = positionLogService.findAll();

        int i = 0;

        while(i < result.size()){
            compare(result.get(i), positionLogDTOList.get(i));

            i++;
        }
    }

    @Test
    public void testSavePositionLog(){
        Long id = 1l;

        PositionLog positionLog = positionLogTestFactory.positionLog(id);
        PositionLogDTO positionLogDTO = positionLogTestFactory.positionLogDTO(id);

        Mockito.when(mapper.toPositionLog(positionLogDTO)).thenReturn(positionLog);

        Assertions.assertEquals(id, positionLogService.save(positionLogDTO));
    }

    @Test
    public void testAlterPositionLogExisting(){
        Long id = 1l;

        PositionLog positionLog = positionLogTestFactory.positionLog(id);
        PositionLogDTO positionLogDTO = positionLogTestFactory.positionLogDTO(id);

        Mockito.when(positionLogRepository.findByPositionLogIdAndActive(id, Boolean.TRUE)).thenReturn(Optional.of(positionLog));
        Mockito.when(mapper.toPositionLog(positionLogDTO)).thenReturn(positionLog);

        Assertions.assertEquals(id, positionLogService.save(id, positionLogDTO));
    }

    @Test
    public void testAlterPositionLogAbsent(){
        Long id = 1l;

        PositionLogDTO positionLogDTO = positionLogTestFactory.positionLogDTO(id);

        Mockito.when(positionLogRepository.findByPositionLogIdAndActive(id, Boolean.TRUE)).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, () -> positionLogService.save(id, positionLogDTO));
    }

    @Test
    public void testDeletePositionLogAbsent(){
        Long id = 1l;

        Mockito.when(positionLogRepository.findByPositionLogIdAndActive(id, Boolean.TRUE)).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, () -> positionLogService.delete(id));
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