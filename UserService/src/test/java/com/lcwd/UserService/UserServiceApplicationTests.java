package com.lcwd.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.lcwd.UserService.entity.Rating;
import com.lcwd.UserService.externalServices.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private RatingService ratingService;
	
	@Test
	void createRatings() {
		Rating rating= Rating.builder()
				.rating(9)
				.userId("")
				.hotelId("")
				.feedback("created by feign client").build();
		
		ResponseEntity<Rating> newrating = ratingService.createRating(rating);
		Rating ratingsbody = newrating.getBody();
		System.out.println(ratingsbody);
		System.out.println(" new ratying created..");
	}

}
