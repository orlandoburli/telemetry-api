package com.arthur.takeda.icomida.telemetry.demo.controller;

import com.arthur.takeda.icomida.telemetry.demo.dto.DeliverymanDTO;
import com.arthur.takeda.icomida.telemetry.demo.service.DeliverymanService;
import com.sun.net.httpserver.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/deliveryman")
public class DeliverymanController {

    @Autowired
    DeliverymanService deliverymanService;

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.ok(deliverymanService.getById(id));
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(deliverymanService.findAll());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody DeliverymanDTO deliverymanDTO){
        Long id = deliverymanService.save(deliverymanDTO);

        return ResponseEntity.created(URI.create("" + id)).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity save(@PathVariable Long id, @RequestBody DeliverymanDTO deliverymanDTO){
        try {
            deliverymanService.save(id, deliverymanDTO);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try{
            deliverymanService.delete(id);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
