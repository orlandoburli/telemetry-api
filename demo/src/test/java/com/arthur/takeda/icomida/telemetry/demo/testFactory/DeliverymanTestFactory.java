package com.arthur.takeda.icomida.telemetry.demo.testFactory;

import com.arthur.takeda.icomida.telemetry.demo.dto.DeliverymanDTO;
import com.arthur.takeda.icomida.telemetry.demo.model.Deliveryman;

public class DeliverymanTestFactory {

    public Deliveryman deliveryman(Long id){
        Deliveryman deliveryman = new Deliveryman();

        deliveryman.setDeliverymanId(id);
        deliveryman.setBatteryStatus("ATIVA");
        deliveryman.setCpf("11133322244");
        deliveryman.setName("Test");
        deliveryman.setStatus("ATIVO");

        return deliveryman;
    }

    public DeliverymanDTO deliverymanDTO(Long id){
        DeliverymanDTO deliverymanDTO = new DeliverymanDTO();

        deliverymanDTO.setDeliverymanId(id);
        deliverymanDTO.setBatteryStatus("ATIVA");
        deliverymanDTO.setCpf("11133322244");
        deliverymanDTO.setName("Test");
        deliverymanDTO.setStatus("ATIVO");

        return deliverymanDTO;
    }

}
