package com.homework.triple.Mapper;

import com.homework.triple.Entity.Point;
import com.homework.triple.Entity.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PointMapper {

    //유저의 포인트 조회
    List<Point> selectPoint(String userId);
    //리뷰 포인트 최근기록 조회
    Point selectReviewPoint(Point p);
    //포인트 등록 이벤트
    int insertPointEvent(Point p);
    //특정 장소 첫 리뷰 조회
    Review selectReviewPlace(Point p);
}
