package com.cydeo.model;

import com.cydeo.enums.RecipeType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Recipe {

    private UUID id;
    private String name;
    private int duration;

    private String preparation;
    private List<Ingredients> ingredients;

    private RecipeType recipeType;

}
