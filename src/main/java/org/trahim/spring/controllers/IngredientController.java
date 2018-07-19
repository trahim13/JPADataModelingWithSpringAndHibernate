package org.trahim.spring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.trahim.spring.commands.IngredientCommand;
import org.trahim.spring.commands.RecipeCommand;
import org.trahim.spring.commands.UnitOfMeasureCommand;
import org.trahim.spring.service.IngredientService;
import org.trahim.spring.service.RecipeService;
import org.trahim.spring.service.UnitOfMeasureService;

@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping("recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model) {
        log.debug("Getting ingredients by id:" + recipeId);
        model.addAttribute("recipe", recipeService.findCommandByiId(Long.valueOf(recipeId)));

        return "recipe/ingredients/list";
    }

    @GetMapping ("recipe/{recipeId}/ingredients/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId,
                                       @PathVariable String id, Model model) {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));
        return "recipe/ingredients/show";
    }


    @GetMapping("recipe/{recipeId}/ingredients/{id}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId,
                                         @PathVariable String id, Model model) {

        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));

        model.addAttribute("uomList", unitOfMeasureService.listOfAllUoms());

        return "recipe/ingredients/ingredientform";

    }


    @PostMapping
    ("recipe/{recipeId}/ingredients")
    public String saveOrUpdate(@ModelAttribute IngredientCommand command) {
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        log.debug("saved receipe id:" + savedCommand.getRecipeId());
        log.debug("saved ingredient id:" + savedCommand.getId());

        return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredients/" + savedCommand.getId() + "/show";
    }


    @GetMapping("recipe/{recipeId}/ingredients/new")
    public String newRecipe(@PathVariable String recipeId, Model model) {

        RecipeCommand recipeCommand = recipeService.findCommandByiId(Long.valueOf(recipeId));

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setRecipeId(Long.valueOf(recipeId));
        model.addAttribute("ingredient", ingredientCommand);

        ingredientCommand.setUom(new UnitOfMeasureCommand());
        model.addAttribute("uomList", unitOfMeasureService.listOfAllUoms());



        return "recipe/ingredients/ingredientform";
    }


    @GetMapping("recipe/{recipeId}/ingredients/{id}/delete")
    public String deleteIngredient(@PathVariable String recipeId,
                                   @PathVariable String id) {
        log.debug("deleting ingredient id: " + id);

        ingredientService.deleteIngredient(Long.valueOf(recipeId), Long.valueOf(id));

        return "redirect:/recipe/" + recipeId + "/ingredients";
    }
}
