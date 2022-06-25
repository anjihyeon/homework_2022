package com.homework.triple.Service;

import com.homework.triple.Entity.Point;
import com.homework.triple.Entity.Review;
import com.homework.triple.Mapper.PointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PointService {

    @Autowired
    private PointMapper mapper;

    public ResponseEntity selectPoint(String userId){
        Map<String, Object> map = new HashMap<>();

        List<Point> list = mapper.selectPoint(userId);
        int point = 0;
        for(int i=0;i<list.size();i++){
            point += list.get(i).getPoint();
        }

        map.put("result",1);
        map.put("point",point);

        return new ResponseEntity(map, HttpStatus.OK);
    }

    public ResponseEntity getPointEvent(Point p){
        Map<String, Object> map = new HashMap<>();
        Point p2 = mapper.selectReviewPoint(p);
        int score = 0;

        if(p2 != null){
            score = p2.getPoint();
        }

        Review r = mapper.selectReviewPlace(p);

        if(p.getAction().equals("MOD")){
            if(r.getReviewId() == p.getReviewId()){
                if(p.getContent().length() == 0){
                    if(score != 1){
                        score = score - 1;
                    }
                }else{
                    if(score != 3){
                        score = score + 1;
                    }
                }
                if(p.getAttachedPhotoIds().length() == 0){
                    if(score != 1){
                        score = score - 1;
                    }
                }else{
                    if(score != 3) {
                        score = score + 1;
                    }
                }
            }else{
                if(p.getContent().length() == 0){
                    if(score != 0){
                        score = score - 1;
                    }
                }else{
                    if(score != 2) {
                        score = score + 1;
                    }
                }
                if(p.getAttachedPhotoIds().length() == 0){
                    if(score != 0) {
                        score = score - 1;
                    }
                }else{
                    if(score != 2) {
                        score = score + 1;
                    }
                }
            }
        }else if(p.getAction().equals("ADD")){
            if (p.getContent().length() != 0) {
                score = score + 1;
            }
            if (p.getAttachedPhotoIds().length() != 0) {
                score = score + 1;
            }
            if (r.getCount() == 1) {
                score = score + 1;
            }
        }else{
            score = 0;
        }
        p.setPoint(score);
        if (mapper.insertPointEvent(p) == 1) {
            map.put("result", 1);
        } else {
            map.put("result", 0);
        }

        return new ResponseEntity(map, HttpStatus.OK);
    }
}
