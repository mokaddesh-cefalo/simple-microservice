package com.shovon.moviecatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRating {
    List<Rating> ratings;
}
