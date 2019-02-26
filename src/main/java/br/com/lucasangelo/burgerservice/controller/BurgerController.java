package br.com.lucasangelo.burgerservice.controller;

import br.com.lucasangelo.burgerservice.model.Burger;
import br.com.lucasangelo.burgerservice.model.BurgerIngredient;
import br.com.lucasangelo.burgerservice.service.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/burger")
public class BurgerController {
    private final BurgerService burgerService;

    @Autowired
    public BurgerController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{burgerId}")
    public ResponseEntity getBurger(@PathVariable Integer burgerId) {
        Optional<Burger> burger = this.burgerService.getBurger(burgerId);
        return ResponseEntity.ok(burger);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity listBurgers() {
        Iterable<Burger> burgers = this.burgerService.getBurgerList();
        return ResponseEntity.ok(burgers);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{burgerId}/ingredients")
    public ResponseEntity listBurgerIngredients(@PathVariable Integer burgerId) {
        Iterable<BurgerIngredient> ingredients = this.burgerService.getBurgerIngredients(burgerId);
        return ResponseEntity.ok(ingredients);
    }
}
