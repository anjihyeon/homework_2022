package com.homework.triple;

import com.homework.triple.Entity.Point;
import com.homework.triple.Service.PointService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TripleApplicationTests {

	@Autowired
	private PointService service;

	@Test
	void test1() {
		System.out.println(service.selectPoint("1"));
	}
	@Test
	void test2() {
		System.out.println(service.selectPoint("3ede0ef2-92b7-4817-a5f3-0c575361f742"));
	}
	@Test
	void test3() {
		Point p = new Point();
		p.setType("REVIEW");
		p.setAction("ADD");
		p.setContent("좋아요!");
		p.setAttachedPhotoIds("1,2,3");
		p.setReviewId("1");
		p.setUserId("1");
		p.setPlaceId("1");

		System.out.println(service.getPointEvent(p));
	}
	@Test
	void test4() {
		Point p = new Point();
		p.setType("REVIEW");
		p.setAction("MOD");
		p.setContent("1");
		p.setAttachedPhotoIds("1,2");
		p.setReviewId("1");
		p.setUserId("1");
		p.setPlaceId("1");

		System.out.println(service.getPointEvent(p));
	}
}
