package br.com.lucasangelo.burgerservice.repository;

import br.com.lucasangelo.burgerservice.model.Burger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Integer> {
}
