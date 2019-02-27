package br.com.lucasangelo.burgerservice.response;

import br.com.lucasangelo.burgerservice.model.BurgerIngredient;
import br.com.lucasangelo.burgerservice.model.Ingredient;

public class IngredientResponse {
    private Integer id;
    private String name;
    private Float price;
    private Integer quantity;

    public IngredientResponse(Ingredient ingredient, Integer quantity) {
        this.id = ingredient.getId();
        this.name = ingredient.getName();
        this.price = ingredient.getPrice();
        this.quantity = quantity;
    }

    public IngredientResponse(BurgerIngredient burgerIngredient) {
        this.id = burgerIngredient.getId().getIngredient().getId();
        this.name = burgerIngredient.getId().getIngredient().getName();
        this.price = burgerIngredient.getId().getIngredient().getPrice();
        this.quantity = burgerIngredient.getQuantity();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
