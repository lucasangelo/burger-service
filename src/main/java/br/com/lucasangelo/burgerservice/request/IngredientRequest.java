package br.com.lucasangelo.burgerservice.request;

import br.com.lucasangelo.burgerservice.model.BurgerIngredient;

public class IngredientRequest {
    private Integer id;
    private Integer quantity;

    public IngredientRequest() {

    }

    public IngredientRequest(BurgerIngredient burgerIngredient) {
        this.id = burgerIngredient.getId().getIngredient().getId();
        this.quantity = burgerIngredient.getQuantity();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
