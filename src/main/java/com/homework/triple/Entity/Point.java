package com.homework.triple.Entity;

import lombok.Data;

@Data
public class Point {

    private int pointId;
    private String type;
    private String action;
    private int userId;
    private int point;

    private int reviewId;
    private String attachedPhotoIds;
    private int placeId;
}
