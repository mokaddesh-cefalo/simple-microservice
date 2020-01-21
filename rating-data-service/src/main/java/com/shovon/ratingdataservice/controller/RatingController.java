package com.shovon.ratingdataservice.controller;

import com.shovon.ratingdataservice.model.Rating;
import com.shovon.ratingdataservice.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {
    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 3.12);
    }

    @GetMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){
        System.out.println("Ok");
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 3.12),
                new Rating("5678", 4)
        );
        UserRating userRating =  new UserRating(ratings);
        return userRating;
    }
}
