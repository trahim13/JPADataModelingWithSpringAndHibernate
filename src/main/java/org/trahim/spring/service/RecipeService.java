package org.trahim.spring.service;

import org.trahim.spring.commands.RecipeCommand;
import org.trahim.spring.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandByiId(Long id);

    public void deleteById(Long id);

}
