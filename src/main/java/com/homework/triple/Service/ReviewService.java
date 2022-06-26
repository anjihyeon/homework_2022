package com.homework.triple.Service;

import com.homework.triple.Entity.Review;
import com.homework.triple.Mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper mapper;

    public int insertReview(Review r){
        return mapper.insertReview(r);
    }
    public int modifyReview(Review r){
        return mapper.modifyReview(r);
    }
    public int deleteReview(String reviewId){
        return mapper.deleteReview(reviewId);
    }
}
