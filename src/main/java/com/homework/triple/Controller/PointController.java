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
    //포인트 적립 api
    @PostMapping("/events")
    public ResponseEntity getPointEvent(Point p){
        return service.getPointEvent(p);
    }
    //포인트 조회 api
    @PostMapping("/point")
    public ResponseEntity selectPoint(@RequestParam("userId")String userId){
        return service.selectPoint(userId);
    }

}
