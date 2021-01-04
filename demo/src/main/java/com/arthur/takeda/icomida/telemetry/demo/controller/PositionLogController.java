package com.arthur.takeda.icomida.telemetry.demo.controller;

import com.arthur.takeda.icomida.telemetry.demo.dto.PositionLogDTO;
import com.arthur.takeda.icomida.telemetry.demo.model.PositionLog;
import com.arthur.takeda.icomida.telemetry.demo.service.PositionLogService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/position_log")
public class PositionLogController {

    @Autowired
    private PositionLogService positionLogService;

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.ok(positionLogService.findById(id));
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(positionLogService.findAll());
    }

    @PostMapping("/post")
    public ResponseEntity save(@RequestBody PositionLogDTO positionLogDTO){
        Long id = positionLogService.save(positionLogDTO);

        return ResponseEntity.created(URI.create("" + id)).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity save(@PathVariable Long id, @RequestBody PositionLogDTO positionLogDTO)  {
        try{
            positionLogService.save(positionLogDTO, id);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try{
            positionLogService.delete(id);
        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}
