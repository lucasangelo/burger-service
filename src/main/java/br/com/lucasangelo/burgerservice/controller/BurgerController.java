package br.com.lucasangelo.burgerservice.controller;

import br.com.lucasangelo.burgerservice.model.Burger;
import br.com.lucasangelo.burgerservice.request.IngredientRequest;
import br.com.lucasangelo.burgerservice.response.BurgerResponse;
import br.com.lucasangelo.burgerservice.response.IngredientResponse;
import br.com.lucasangelo.burgerservice.service.BurgerService;
import br.com.lucasangelo.burgerservice.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/burgers")
public class BurgerController {
    private final BurgerService burgerService;
    private final IngredientService ingredientService;

    @Autowired
    public BurgerController(BurgerService burgerService, IngredientService ingredientService) {
        this.burgerService = burgerService;
        this.ingredientService = ingredientService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{burgerId}")
    public ResponseEntity findBurger(@PathVariable Integer burgerId) {
        Optional<Burger> burger = this.burgerService.findBurger(burgerId);
        if (burger.isPresent()) {
            Float price = this.burgerService.calculateBurgerPrice(burgerId);
            BurgerResponse burgerResponse = new BurgerResponse(burger.get(),
                    this.burgerService.findBurgerIngredients(burgerId), price);
            return ResponseEntity.ok(burgerResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listBurgers() {
        Iterable<Burger> burgers = this.burgerService.listBurgers();
        return ResponseEntity.ok(burgers);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/price")
    public ResponseEntity calculatePrice(@RequestBody Iterable<IngredientRequest> ingredientRequest) {
        Float price = this.burgerService.calculatePrice(ingredientRequest);
        BurgerResponse burgerResponse = new BurgerResponse(this.ingredientService.listIngredients(ingredientRequest), price);
        return ResponseEntity.ok(burgerResponse);
    }
}
