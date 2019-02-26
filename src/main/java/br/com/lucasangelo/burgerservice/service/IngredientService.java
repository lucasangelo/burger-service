package br.com.lucasangelo.burgerservice.service;

import br.com.lucasangelo.burgerservice.model.Ingredient;
import br.com.lucasangelo.burgerservice.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Iterable<Ingredient> getIngredientList() {
        return this.ingredientRepository.findAll();
    }
}
