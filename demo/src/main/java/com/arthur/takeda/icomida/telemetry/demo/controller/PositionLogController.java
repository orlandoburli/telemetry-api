package com.arthur.takeda.icomida.telemetry.demo.controller;

import com.arthur.takeda.icomida.telemetry.demo.dto.PositionLogDTO;
import com.arthur.takeda.icomida.telemetry.demo.service.PositionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/position_log")
public class PositionLogController {

    @Autowired
    private PositionLogService positionLogService;

    @PostMapping("/post")
    public ResponseEntity save(@Valid @RequestBody PositionLogDTO positionLogDTO){
        Long id = positionLogService.save(positionLogDTO);

        return ResponseEntity.created(URI.create("" + id)).build();
    }
}
