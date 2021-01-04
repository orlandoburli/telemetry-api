package com.arthur.takeda.icomida.telemetry.demo.service;

import com.arthur.takeda.icomida.telemetry.demo.dto.DeliverymanDTO;
import com.arthur.takeda.icomida.telemetry.demo.dto.mapper.DeliverymanMapper;
import com.arthur.takeda.icomida.telemetry.demo.model.Deliveryman;
import com.arthur.takeda.icomida.telemetry.demo.repository.DeliverymanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class DeliverymanService {

    @Autowired
    private DeliverymanRepository deliverymanRepository;

    @Autowired
    private DeliverymanMapper mapper;

    public DeliverymanDTO getById(Long id){
        Optional<Deliveryman> deliveryman = deliverymanRepository.findByDeliverymanIdAndActive(id, Boolean.TRUE);

        if(deliveryman.isEmpty()){
            return new DeliverymanDTO();
        }

        return mapper.toDeliverymanDTO(deliveryman.get());
    }

    public List<DeliverymanDTO> findAll(){
        List<Deliveryman> deliverymanList = deliverymanRepository.findAllByActive(Boolean.TRUE);

        return deliverymanList
                .parallelStream()
                .map(mapper::toDeliverymanDTO)
                .collect(Collectors.toList());
    }

    public Long save(DeliverymanDTO deliverymanDTO){
        Deliveryman deliveryman = mapper.toDeliveryman(deliverymanDTO);

        deliverymanRepository.save(deliveryman);

        return deliveryman.getDeliverymanId();
    }

    public Long save(Long id, DeliverymanDTO deliverymanDTO) throws Exception {
        Optional<Deliveryman> deliverymanRecord = deliverymanRepository.findById(id);
        Deliveryman deliveryman;

        if(deliverymanRecord.isEmpty()){
            throw new Exception("Deliveryman not found");
        }

        deliverymanDTO.setDeliverymanId(id);

        deliverymanRepository.save(mapper.toDeliveryman(deliverymanDTO));

        return deliverymanRecord.get().getDeliverymanId();
    }

    @Transactional
    public void delete(Long id) throws Exception {
        Optional<Deliveryman> deliverymanRecord = deliverymanRepository.findByDeliverymanIdAndActive(id, Boolean.TRUE);
        Deliveryman deliveryman;

        if(deliverymanRecord.isEmpty()){
            throw new Exception("Deliveryman not found");
        }

        deliveryman = deliverymanRecord.get();

        deliveryman.setActive(Boolean.FALSE);
    }

}
