package com.homework.triple.Mapper;

import com.homework.triple.Entity.Point;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PointMapper {

    List<Point> selectPoint(int userId);
    int getPointEvent(Point p);
}
