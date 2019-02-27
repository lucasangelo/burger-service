package br.com.lucasangelo.burgerservice.repository;

import br.com.lucasangelo.burgerservice.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
}
