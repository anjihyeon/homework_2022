package com.homework.triple.Mapper;

import com.homework.triple.Entity.Point;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PointMapper {

    //유저의 포인트 조회
    List<Point> selectPoint(String userId);
    //리뷰 조회
    Point selectReview(Point p);
    //포인트 등록 이벤트
    int insertPointEvent(Point p);

    //특정 장소 첫 리뷰 조회
    int selectReviewPlace(Point p);
}
