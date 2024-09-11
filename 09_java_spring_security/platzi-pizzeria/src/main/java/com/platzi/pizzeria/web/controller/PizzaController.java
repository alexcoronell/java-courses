package com.platzi.pizzeria.web.controller;

import com.platzi.pizzeria.persistence.entity.PizzaEntity;
import com.platzi.pizzeria.service.PizzaService;
import com.platzi.pizzeria.service.dto.UpdatePizzaPriceDto;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<Page<PizzaEntity>> getAll(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "8") int elements) {
        return ResponseEntity.ok(pizzaService.getAll(page, elements));
    }

    @GetMapping("/{idPizza}")
    public  ResponseEntity<PizzaEntity> get(@PathVariable int idPizza){
        return ResponseEntity.ok(pizzaService.get((idPizza)));
    }

    @GetMapping("/vegan-count")
    public int getVeganCount(){
        return this.pizzaService.getVeganCount();
    }

    @GetMapping("/available")
    public ResponseEntity<Page<PizzaEntity> > getAvailable(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "8") int elements,
                                                           @RequestParam(defaultValue = "price") String sortBy,
                                                           @RequestParam(defaultValue = "ASC") String sortDirection
                                                           ){
        return ResponseEntity.ok(this.pizzaService.getAvailable(page, elements, sortBy, sortDirection));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PizzaEntity> gerByName(@PathVariable String name){
        return ResponseEntity.ok(this.pizzaService.getByName(name));
    }

    @GetMapping("/name-first/{name}")
    public ResponseEntity<PizzaEntity> getFirstAvailableByName(@PathVariable String name){
        return ResponseEntity.ok(this.pizzaService.getFirstAvailableByName(name));
    }

    @GetMapping("/with/{ingredient}")
    public  ResponseEntity<List<PizzaEntity>> getWith(@PathVariable String ingredient) {
        return ResponseEntity.ok(this.pizzaService.getWith(ingredient));
    }

    @GetMapping("/without/{ingredient}")
    public  ResponseEntity<List<PizzaEntity>> getWithout(@PathVariable String ingredient) {
        return ResponseEntity.ok(this.pizzaService.getWithout(ingredient));
    }

    @GetMapping("/cheapest/{price}")
    public ResponseEntity<List<PizzaEntity>> getCheapest(@PathVariable double price) {
        return ResponseEntity.ok(this.pizzaService.getCheapest(price));
    }

    @PostMapping
    public  ResponseEntity<PizzaEntity> add(@RequestBody PizzaEntity pizza){
        if(pizza.getIdPizza() == null || !pizzaService.exist(pizza.getIdPizza())) {
            return ResponseEntity.ok(pizzaService.save(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public  ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizza){
        if(pizza.getIdPizza() != null || pizzaService.exist(pizza.getIdPizza())) {
            return ResponseEntity.ok(pizzaService.save(pizza));
        }
        return  ResponseEntity.badRequest().build();
    }

    @PutMapping("/priceUpdate")
    public ResponseEntity<Void> updatePrice(@RequestBody UpdatePizzaPriceDto dto) {
        if(this.pizzaService.exist(dto.getPizzaId())) {
            System.out.println(dto.getPizzaId());
            this.pizzaService.updatePrice(dto);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<Void> delete(@PathVariable int idPizza) {
        if(pizzaService.exist(idPizza)) {
            pizzaService.delete(idPizza);
            return  ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
