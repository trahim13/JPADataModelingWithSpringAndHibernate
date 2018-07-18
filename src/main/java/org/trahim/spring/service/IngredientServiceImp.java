package org.trahim.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.trahim.spring.commands.IngredientCommand;
import org.trahim.spring.converters.IngredientToIngredientCommand;
import org.trahim.spring.domain.Recipe;
import org.trahim.spring.repositories.RecipeRepository;

import java.util.Optional;

@Service
@Slf4j
public class IngredientServiceImp implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImp(IngredientToIngredientCommand ingredientToIngredientCommand1, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand1;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (!recipeOptional.isPresent()) {
            log.error("recipe is not find by id:" + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient))
                .findFirst();

        if (!ingredientCommandOptional.isPresent()) {
            log.error("ingredient is not found by id" + ingredientId);

        }

        return ingredientCommandOptional.get();
    }
}
