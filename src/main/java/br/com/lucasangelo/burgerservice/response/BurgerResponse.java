package br.com.lucasangelo.burgerservice.response;

import br.com.lucasangelo.burgerservice.model.Burger;
import br.com.lucasangelo.burgerservice.model.BurgerIngredient;

import java.util.ArrayList;
import java.util.List;

public class BurgerResponse {
    private Integer id;
    private String name;
    private Iterable<IngredientResponse> ingredients;
    private Float price;

    public BurgerResponse(Iterable<IngredientResponse> ingredients, Float price){
        this.ingredients = ingredients;
        this.price = price;
    }

    public BurgerResponse(Burger burger, Iterable<BurgerIngredient> burgerIngredients, Float price) {
        this.id = burger.getId();
        this.name = burger.getName();
        List<IngredientResponse> ingredients = new ArrayList<>();
        for (BurgerIngredient burgerIngredient : burgerIngredients) {
            ingredients.add(new IngredientResponse(burgerIngredient));
        }
        this.ingredients = ingredients;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Iterable<IngredientResponse> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Iterable<IngredientResponse> ingredients) {
        this.ingredients = ingredients;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
