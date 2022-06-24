package com.homework.triple.Service;

import com.homework.triple.Entity.Point;
import com.homework.triple.Mapper.PointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PointService {

    //@Autowired
    //private PointMapper mapper;

    public ResponseEntity selectPoint(){
        Map<String, Object> map = new HashMap<>();

        map.put("result",1);

        return new ResponseEntity(map, HttpStatus.OK);
    }

    public ResponseEntity getPointEvent(){
        Map<String, Object> map = new HashMap<>();

        map.put("result",1);

        return new ResponseEntity(map, HttpStatus.OK);
    }
}
