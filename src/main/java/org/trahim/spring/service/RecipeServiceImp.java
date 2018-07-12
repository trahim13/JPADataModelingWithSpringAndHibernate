package org.trahim.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.trahim.spring.domain.Recipe;
import org.trahim.spring.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class RecipeServiceImp implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImp(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("Im in service");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
