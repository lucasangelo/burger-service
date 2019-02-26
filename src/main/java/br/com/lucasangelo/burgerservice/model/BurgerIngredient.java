package br.com.lucasangelo.burgerservice.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class BurgerIngredient {
    @EmbeddedId
    private BurgerIngredientId id;

    private Integer quantity;

    public BurgerIngredientId getId() {
        return id;
    }

    public void setId(BurgerIngredientId id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
