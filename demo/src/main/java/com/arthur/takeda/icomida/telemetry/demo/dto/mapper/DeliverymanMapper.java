package com.arthur.takeda.icomida.telemetry.demo.dto.mapper;

import com.arthur.takeda.icomida.telemetry.demo.dto.DeliverymanDTO;
import com.arthur.takeda.icomida.telemetry.demo.model.Deliveryman;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

@Mapper(componentModel = "spring")
public interface DeliverymanMapper {

    Deliveryman toDeliveryman(DeliverymanDTO deliverymanDTO);

    DeliverymanDTO toDeliverymanDTO(Deliveryman deliveryman);

}
