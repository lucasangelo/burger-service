package br.com.lucasangelo.burgerservice.repository;

import br.com.lucasangelo.burgerservice.model.BurgerIngredient;
import br.com.lucasangelo.burgerservice.model.BurgerIngredientId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BurgerIngredientRepository extends CrudRepository<BurgerIngredient, BurgerIngredientId> {
    Iterable<BurgerIngredient> findById_Burger_Id(Integer burgerId);
}
