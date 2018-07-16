package org.trahim.spring.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.trahim.spring.domain.Difficulty;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {

    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String derection;
    private Byte[] image;
    private Difficulty difficulty;

    private NotesCommand notes;
    private Set<CategoryCommand> categories = new HashSet<>();
    private Set<IngredientCommand> ingredients = new HashSet<>();

}
