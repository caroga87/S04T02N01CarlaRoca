package cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.model.service;

import cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.exception.FruitNotFoundException;
import cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.model.domain.Fruit;

import java.util.List;

public interface IFruitServices {

    Fruit addFruit(Fruit fruit);
    Fruit updateFruitById(int id, Fruit updatedFruit);
    void deleteFruitById(int id) throws FruitNotFoundException;
    Fruit getFruitById(int id);
    List<Fruit> getAllFruits();
}
