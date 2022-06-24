package com.homework.triple.Entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.UUID;

@Data
@Alias("point")
public class Point {

    private String pointId;
    private String type;
    private String action;
    private String userId;
    private int point;
    //
    private String reviewId;
    private String attachedPhotoIds;
    private String content;
    private String placeId;
}
