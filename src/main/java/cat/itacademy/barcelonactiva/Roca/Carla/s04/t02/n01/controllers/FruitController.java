package cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.model.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping ("/fruit")
public class FruitController {

    @Autowired
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping ("/getAllFruits")
    public ResponseEntity<List<Fruit>> getAllFruits () {
        List<Fruit> allFruits= fruitService.getAllFruits();
       return new ResponseEntity<>(allFruits,HttpStatus.OK);

    }

    @GetMapping("/getFruitByID/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable int id) {

        Fruit getFruit = fruitService.getFruitById(id);

        return new ResponseEntity<>(getFruit, HttpStatus.OK);

    }

    @PostMapping ("/addFruit")
    public ResponseEntity<Fruit> addFruit (@RequestBody Fruit fruit) {
        Fruit fruitObj = fruitService.addFruit(fruit);
        return new ResponseEntity<>(fruitObj, HttpStatus.OK);

    }
    @PutMapping ("/updateFruitById/{id}")
    public ResponseEntity<Fruit> updateFruitById (@PathVariable int id, @RequestBody Fruit fruit) {
        Fruit updatedFruit = fruitService.updateFruitById(id, fruit);

        return new ResponseEntity<>(HttpStatus.OK);

    }
    @DeleteMapping ("/deleteFruitById/{id}")
    public ResponseEntity<HttpStatus> deleteFruitById (@PathVariable int id) {
        fruitService.deleteFruitById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
