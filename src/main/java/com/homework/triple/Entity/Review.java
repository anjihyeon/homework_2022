package com.homework.triple.Entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.UUID;

@Data
@Alias("review")
public class Review {

    private String reviewId;
    private String content;
    private String attachedPhotoIds;
    private String placeId;
    private String userId;
}
