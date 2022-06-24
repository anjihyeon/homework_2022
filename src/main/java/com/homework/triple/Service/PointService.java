package com.homework.triple.Service;

import com.homework.triple.Entity.Point;
import com.homework.triple.Entity.Review;
import com.homework.triple.Mapper.PointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PointService {

    @Autowired
    private PointMapper mapper;

    public ResponseEntity selectPoint(Point p){
        Map<String, Object> map = new HashMap<>();


        map.put("result",1);

        return new ResponseEntity(map, HttpStatus.OK);
    }

    public ResponseEntity getPointEvent(Point p){
        Map<String, Object> map = new HashMap<>();
        int score = 0;

        if(p.getAction().equals("MOD")){
            Point p2 = mapper.selectReview(p);
            score = p2.getPoint();

            if(p.getContent().length() == 0){
                score = score - 1;
            }else{
                score = score + 1;
            }
            if(p.getAttachedPhotoIds().length() == 0){
                score = score - 1;
            }else{
                score = score + 1;
            }
            p.setPoint(score);
            if (mapper.insertPointEvent(p) == 1) {
                map.put("result", 1);
            } else {
                map.put("result", 0);
            }
        }else if(p.getAction().equals("ADD")){
            if (p.getContent().length() != 0) {
                score = score + 1;
            }
            if (p.getAttachedPhotoIds().length() != 0) {
                score = score + 1;
            }
            Review r = mapper.selectReviewPlace(p);
            if (r.getCount() == 1) {
                score = score + 1;
            }
            p.setPoint(score);
            if (mapper.insertPointEvent(p) == 1) {
                map.put("result", 1);
            } else {
                map.put("result", 0);
            }
        }else{
            Point p2 = mapper.selectReview(p);
            score = p2.getPoint();

            Review r = mapper.selectReviewPlace(p);
            if(r.getContent().length() != 0){
                score = score - 1;
            }
            if(r.getAttachedPhotoIds().length() != 0){
                score = score - 1;
            }
            if (r.getReviewId().equals(p.getReviewId())) {
                score = score - 1;
            }
            p.setPoint(score);
            if (mapper.insertPointEvent(p) == 1) {
                map.put("result", 1);
            } else {
                map.put("result", 0);
            }
        }

        return new ResponseEntity(map, HttpStatus.OK);
    }
}
