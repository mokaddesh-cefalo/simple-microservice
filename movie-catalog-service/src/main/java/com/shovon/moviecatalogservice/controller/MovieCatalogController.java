package com.shovon.moviecatalogservice.controller;

import com.shovon.moviecatalogservice.model.CatalogItem;
import com.shovon.moviecatalogservice.model.Movie;
import com.shovon.moviecatalogservice.model.Rating;
import com.shovon.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        // get all rated movie IDS
        UserRating userRating = restTemplate.getForObject("http://RATING-DATA-SERVICE/ratingsdata/users/" + userId, UserRating.class);

        List<Rating> ratings = userRating.getRatings();

        // For each movie ID, call movie info and get details
        // put them all together
        return ratings.stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/foo", Movie.class);
                    return new CatalogItem(movie.getName(), "Test Desc", rating.getRating());
                })
                .collect(Collectors.toList());
    }
}
