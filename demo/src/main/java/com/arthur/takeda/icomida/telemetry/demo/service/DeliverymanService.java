package com.arthur.takeda.icomida.telemetry.demo.service;

import com.arthur.takeda.icomida.telemetry.demo.model.Deliveryman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliverymanService {

    @Autowired
    private DeliverymanRepository deliverymanRepository;

    public Deliveryman getById(Long id){
        return
    }

}
