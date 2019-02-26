package br.com.lucasangelo.burgerservice.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class BurgerIngredientId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "burger_id")
    private Burger burger;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    public BurgerIngredientId(Burger burger, Ingredient ingredient) {
        this.burger = burger;
        this.ingredient = ingredient;
    }

    public Burger getBurger() {
        return burger;
    }

    public void setBurger(Burger burger) {
        this.burger = burger;
    }


    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
