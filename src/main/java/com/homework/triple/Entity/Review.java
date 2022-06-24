package com.homework.triple.Entity;

import lombok.Data;

@Data
public class Review {

    private int reviewId;
    private String content;
    private String attachedPhotoIds;
}
