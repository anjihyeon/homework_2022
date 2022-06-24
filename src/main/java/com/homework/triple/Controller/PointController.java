package com.homework.triple.Controller;

import com.homework.triple.Entity.Point;
import com.homework.triple.Service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointController {

    @Autowired
    private PointService service;

    @PostMapping("/events")
    public ResponseEntity getPointEvent(){
        return service.getPointEvent();
    }

    @PostMapping("/point")
    public ResponseEntity selectPoint(){
        return service.selectPoint();
    }

}
