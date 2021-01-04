package com.arthur.takeda.icomida.telemetry.demo.dto.mapper;

import com.arthur.takeda.icomida.telemetry.demo.dto.PositionLogDTO;
import com.arthur.takeda.icomida.telemetry.demo.dto.mapper.decorator.PositionLogDecorator;
import com.arthur.takeda.icomida.telemetry.demo.model.PositionLog;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(PositionLogDecorator.class)
public interface PositionLogMapper {

    public PositionLog toPositionLog(PositionLogDTO positionLogDTO);

    public PositionLogDTO toPositionLogDto(PositionLog positionLog);

}
