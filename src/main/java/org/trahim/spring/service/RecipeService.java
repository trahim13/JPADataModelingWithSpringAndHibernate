package org.trahim.spring.service;

import org.trahim.spring.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);

}
