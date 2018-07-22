package org.trahim.spring.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.trahim.spring.domain.Difficulty;

import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {

    private Long id;
    @NotBlank
    @Size(min = 3, max = 255)
    private String description;
    @Min(1)
    @Max(999)
    @NotNull
    private Integer prepTime;
    @Min(1)
    @Max(999)
    @NotNull
    private Integer cookTime;
    @Min(1)
    @Max(100)
    @NotNull
    private Integer servings;
    private String source;
    @URL
    @NotBlank
    private String url;
    @NotBlank
    private String derection;
    private Byte[] image;
    private Difficulty difficulty;

    private NotesCommand notes;
    private Set<CategoryCommand> categories = new HashSet<>();
    private Set<IngredientCommand> ingredients = new HashSet<>();

}
