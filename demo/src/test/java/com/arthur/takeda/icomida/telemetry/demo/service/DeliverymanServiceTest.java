package com.arthur.takeda.icomida.telemetry.demo.service;

import com.arthur.takeda.icomida.telemetry.demo.dto.DeliverymanDTO;
import com.arthur.takeda.icomida.telemetry.demo.dto.mapper.DeliverymanMapper;
import com.arthur.takeda.icomida.telemetry.demo.exception.NotFoundException;
import com.arthur.takeda.icomida.telemetry.demo.model.Deliveryman;
import com.arthur.takeda.icomida.telemetry.demo.repository.DeliverymanRepository;
import com.arthur.takeda.icomida.telemetry.demo.testFactory.DeliverymanTestFactory;
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
public class DeliverymanServiceTest {

    @Mock
    private DeliverymanRepository deliverymanRepository;

    @Mock
    private DeliverymanMapper mapper;

    @InjectMocks
    private DeliverymanService deliverymanService;

    private DeliverymanTestFactory deliverymanTestFactory = new DeliverymanTestFactory();

    @Test
    public void testGetDeliverymanExisting(){
        Long id = 1l;

        DeliverymanDTO deliverymanDTO = deliverymanTestFactory.deliverymanDTO(id);
        Deliveryman deliveryman = deliverymanTestFactory.deliveryman(id);

        Mockito.when(deliverymanRepository.findByDeliverymanIdAndActive(id, Boolean.TRUE)).thenReturn(Optional.of(deliveryman));
        Mockito.when(mapper.toDeliverymanDTO(deliveryman)).thenReturn(deliverymanDTO);

        compare(deliverymanDTO, deliverymanService.findById(id));
    }

    @Test
    public void testGetDeliverymanAbsent(){
        Long id = 1l;

        Mockito.when(deliverymanRepository.findByDeliverymanIdAndActive(id, Boolean.TRUE)).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, () -> deliverymanService.findById(id));
    }

    @Test
    public void testGetAllDeliveryman(){
        Long id = 1l;

        List<Deliveryman> deliverymanList = List.of(deliverymanTestFactory.deliveryman(id), deliverymanTestFactory.deliveryman(id + 1));
        List<DeliverymanDTO> deliverymanDTOList = List.of(deliverymanTestFactory.deliverymanDTO(id), deliverymanTestFactory.deliverymanDTO(id + 1));

        Mockito.when(deliverymanRepository.findAllByActive(Boolean.TRUE)).thenReturn(deliverymanList);
        Mockito.when(mapper.toDeliverymanDTO(deliverymanList.get(0))).thenReturn(deliverymanDTOList.get(0));
        Mockito.when(mapper.toDeliverymanDTO(deliverymanList.get(1))).thenReturn(deliverymanDTOList.get(1));

        List<DeliverymanDTO> result = deliverymanService.findAll();

        int i = 0;

        while (i < result.size()){
            compare(deliverymanDTOList.get(i), result.get(i));

            i++;
        }
    }

    @Test
    public void testSaveDeliveryman(){
        Long id = 1l;

        DeliverymanDTO deliverymanDTO = deliverymanTestFactory.deliverymanDTO(id);
        Deliveryman deliveryman = deliverymanTestFactory.deliveryman(id);

        Mockito.when(mapper.toDeliveryman(deliverymanDTO)).thenReturn(deliveryman);

        Assertions.assertEquals(id, deliverymanService.save(deliverymanDTO));
    }

    @Test
    public void testAlterDeliverymanExisting(){
        Long id = 1l;

        DeliverymanDTO deliverymanDTO = deliverymanTestFactory.deliverymanDTO(id);
        Deliveryman deliveryman = deliverymanTestFactory.deliveryman(id);

        Mockito.when(deliverymanRepository.findByDeliverymanIdAndActive(id, Boolean.TRUE)).thenReturn(Optional.of(deliveryman));
        Mockito.when(mapper.toDeliveryman(deliverymanDTO)).thenReturn(deliveryman);

        Assertions.assertEquals(id, deliverymanService.save(id, deliverymanDTO));
    }

    @Test
    public void testAlterDeliverymanAbsent(){
        Long id = 1l;

        DeliverymanDTO deliverymanDTO = deliverymanTestFactory.deliverymanDTO(id);

        Mockito.when(deliverymanRepository.findByDeliverymanIdAndActive(id, Boolean.TRUE)).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, () -> deliverymanService.save(id, deliverymanDTO));
    }

    @Test
    public void testDeleteDeliverymanAbsent(){
        Long id = 1l;

        Mockito.when(deliverymanRepository.findByDeliverymanIdAndActive(id, Boolean.TRUE)).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, () -> deliverymanService.delete(id));
    }

    private void compare(DeliverymanDTO expected, DeliverymanDTO actual){
        Assertions.assertAll(
                () -> Assertions.assertEquals(expected.getDeliverymanId(), actual.getDeliverymanId()),
                () -> Assertions.assertEquals(expected.getBatteryStatus(), actual.getBatteryStatus()),
                () -> Assertions.assertEquals(expected.getCpf(), actual.getCpf()),
                () -> Assertions.assertEquals(expected.getName(), actual.getName()),
                () -> Assertions.assertEquals(expected.getStatus(), actual.getStatus())
        );
    }
}