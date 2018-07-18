package org.trahim.spring.service;

import org.trahim.spring.commands.IngredientCommand;

public interface IngredientService  {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
