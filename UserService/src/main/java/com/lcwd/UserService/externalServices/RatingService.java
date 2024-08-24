package com.lcwd.UserService.externalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lcwd.UserService.entity.Rating;

@Service
@FeignClient(name="RATINGSERVICE")
public interface RatingService {
	
	// post mapping
	@PostMapping("/ratings/createRating")
	public ResponseEntity<Rating> createRating(Rating values);
	
	@PutMapping("ratings/{ratingId}")
	public ResponseEntity<Rating> updateRating(@PathVariable String ratingId, Rating values);
	
	@DeleteMapping("ratings/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);

}
