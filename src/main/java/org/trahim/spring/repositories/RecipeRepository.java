package org.trahim.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.trahim.spring.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
