package br.com.lucasangelo.burgerservice.controller;

import br.com.lucasangelo.burgerservice.model.Ingredient;
import br.com.lucasangelo.burgerservice.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity listIngredients(){
        Iterable<Ingredient> ingredients = this.ingredientService.listIngredients();
        return ResponseEntity.ok(ingredients);
    }
}
