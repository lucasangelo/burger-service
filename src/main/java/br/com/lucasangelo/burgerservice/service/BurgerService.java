package br.com.lucasangelo.burgerservice.service;

import br.com.lucasangelo.burgerservice.model.Burger;
import br.com.lucasangelo.burgerservice.model.BurgerIngredient;
import br.com.lucasangelo.burgerservice.model.Ingredient;
import br.com.lucasangelo.burgerservice.model.IngredientType;
import br.com.lucasangelo.burgerservice.repository.BurgerIngredientRepository;
import br.com.lucasangelo.burgerservice.repository.BurgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BurgerService {
    private final BurgerRepository burgerRepository;
    private final BurgerIngredientRepository burgerIngredientRepository;

    @Autowired
    public BurgerService(BurgerRepository burgerRepository, BurgerIngredientRepository burgerIngredientRepository) {
        this.burgerRepository = burgerRepository;
        this.burgerIngredientRepository = burgerIngredientRepository;
    }

    public Optional<Burger> getBurger(Integer id) {
        return this.burgerRepository.findById(id);
    }

    public Iterable<Burger> getBurgerList() {
        return this.burgerRepository.findAll();
    }

    public Iterable<BurgerIngredient> getBurgerIngredients(Integer burgerId) {
        return this.burgerIngredientRepository.findById_Burger_Id(burgerId);
    }

    public Double calculatePrice(Iterable<BurgerIngredient> ingredients) {
        double totalPrice = 0.0;
        boolean salad = false;
        boolean bacon = false;
        Integer quantity;
        for (BurgerIngredient burgerIngredient : ingredients) {
            Ingredient ingredient = burgerIngredient.getId().getIngredient();
            quantity = burgerIngredient.getQuantity();
            switch (ingredient.getType()) {
                case MEAT:
                case CHEESE:
                    Integer promo = 3;
                    Integer discount = burgerIngredient.getQuantity() / promo;
                    quantity -= discount;
                    break;
                case SALAD:
                    salad = true;
                    break;
                case BACON:
                    bacon = true;
                    break;
            }
            totalPrice += ingredient.getPrice() * quantity;
        }
        if (salad && !bacon) {
            Double priceDiscount = totalPrice*0.1;
            totalPrice -= priceDiscount;
        }

        return totalPrice;
    }
}
