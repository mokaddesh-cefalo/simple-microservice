package com.shovon.moviecatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CatalogItem {
    private String name;
    private String desc;
    private double rating;
}
