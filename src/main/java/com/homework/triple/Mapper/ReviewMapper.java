package com.homework.triple.Mapper;

import com.homework.triple.Entity.Review;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {

    //리뷰 등록
    int insertReview(Review r);
    //리뷰 수정
    int modifyReview(Review r);
    //리뷰 삭제
    int deleteReview(String reviewId);
}
