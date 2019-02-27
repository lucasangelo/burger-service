package br.com.lucasangelo.burgerservice.service;

import br.com.lucasangelo.burgerservice.model.Burger;
import br.com.lucasangelo.burgerservice.model.BurgerIngredient;
import br.com.lucasangelo.burgerservice.model.Ingredient;
import br.com.lucasangelo.burgerservice.repository.BurgerIngredientRepository;
import br.com.lucasangelo.burgerservice.repository.BurgerRepository;
import br.com.lucasangelo.burgerservice.request.IngredientRequest;
import br.com.lucasangelo.burgerservice.response.BurgerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BurgerService {
    private final BurgerRepository burgerRepository;
    private final BurgerIngredientRepository burgerIngredientRepository;
    private final IngredientService ingredientService;

    @Autowired
    public BurgerService(BurgerRepository burgerRepository, BurgerIngredientRepository burgerIngredientRepository,
                         IngredientService ingredientService) {
        this.burgerRepository = burgerRepository;
        this.burgerIngredientRepository = burgerIngredientRepository;
        this.ingredientService = ingredientService;
    }

    public Optional<Burger> findBurger(Integer id) {
        return this.burgerRepository.findById(id);
    }

    public Float calculateBurgerPrice(Integer id) {
        Iterable<BurgerIngredient> burgerIngredients = this.findBurgerIngredients(id);
        List<IngredientRequest> ingredients = new ArrayList<>();
        for (BurgerIngredient burgerIngredient : burgerIngredients) {
            ingredients.add(new IngredientRequest(burgerIngredient));
        }
        return this.calculatePrice(ingredients);
    }

    public Iterable<Burger> listBurgers() {
        return this.burgerRepository.findAll();
    }

    public Iterable<BurgerIngredient> findBurgerIngredients(Integer burgerId) {
        return this.burgerIngredientRepository.findById_Burger_Id(burgerId);
    }

    public Float calculatePrice(Iterable<IngredientRequest> ingredientList) {
        float totalPrice = 0;
        boolean salad = false;
        boolean bacon = false;
        Integer quantity;
        for (IngredientRequest burgerIngredient : ingredientList) {
            Optional<Ingredient> ingredient = this.ingredientService.findIngredient(burgerIngredient.getId());
            if (ingredient.isPresent()) {
                quantity = burgerIngredient.getQuantity();
                switch (ingredient.get().getType()) {
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
                totalPrice += ingredient.get().getPrice() * quantity;
            }
        }
        if (salad && !bacon) {
            Double priceDiscount = totalPrice*0.1;
            totalPrice -= priceDiscount;
        }

        return totalPrice;
    }
}
