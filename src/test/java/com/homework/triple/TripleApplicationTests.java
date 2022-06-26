package com.homework.triple;

import com.homework.triple.Entity.Point;
import com.homework.triple.Entity.Review;
import com.homework.triple.Service.PointService;
import com.homework.triple.Service.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TripleApplicationTests {

	@Autowired
	private PointService pointService;
	@Autowired
	private ReviewService reviewService;

	@Test
	void PointTest() {
		pointService.selectPoint("1");
	}
	@Test
	void ReviewAddTest() {
		Review r = new Review();
		r.setReviewId("1");
		r.setContent("1");
		r.setAttachedPhotoIds("1");
		r.setPlaceId("1");
		r.setUserId("1");
		reviewService.insertReview(r);

		Point p = new Point();
		p.setType("REVIEW");
		p.setAction("ADD");
		p.setContent("1");
		p.setAttachedPhotoIds("1");
		p.setReviewId("1");
		p.setUserId("1");
		p.setPlaceId("1");

		pointService.getPointEvent(p);
	}
	@Test
	void ReviewModTest() {
		Review r = new Review();
		r.setReviewId("1");
		r.setContent("");
		r.setAttachedPhotoIds("");
		reviewService.modifyReview(r);

		Point p = new Point();
		p.setType("REVIEW");
		p.setAction("MOD");
		p.setContent("");
		p.setAttachedPhotoIds("");
		p.setReviewId("1");
		p.setUserId("1");
		p.setPlaceId("1");

		pointService.getPointEvent(p);
	}

	@Test
	void ReviewDeleteTest() {
		reviewService.deleteReview("1");

		Point p = new Point();
		p.setType("REVIEW");
		p.setAction("DELETE");
		p.setContent("");
		p.setAttachedPhotoIds("");
		p.setReviewId("1");
		p.setUserId("1");
		p.setPlaceId("1");

		pointService.getPointEvent(p);
	}
}
