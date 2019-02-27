package br.com.lucasangelo.burgerservice.service;

import br.com.lucasangelo.burgerservice.model.Ingredient;
import br.com.lucasangelo.burgerservice.repository.IngredientRepository;
import br.com.lucasangelo.burgerservice.request.IngredientRequest;
import br.com.lucasangelo.burgerservice.response.IngredientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Iterable<Ingredient> listIngredients() {
        return this.ingredientRepository.findAll();
    }

    public Iterable<IngredientResponse> listIngredients(Iterable<IngredientRequest> ingredientsList) {
        List<IngredientResponse> ingredientResponses = new ArrayList<>();
        for (IngredientRequest ingredientRequest: ingredientsList) {
            Optional<Ingredient> ingredient = this.ingredientRepository.findById(ingredientRequest.getId());
            if (ingredient.isPresent()) {
                ingredientResponses.add(new IngredientResponse(ingredient.get(), ingredientRequest.getQuantity()));
            }

        }
        return ingredientResponses;
    }

    public Optional<Ingredient> findIngredient(Integer id) {
        return this.ingredientRepository.findById(id);
    }
}
