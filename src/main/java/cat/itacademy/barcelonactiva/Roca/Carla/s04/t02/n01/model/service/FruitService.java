package cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.model.service;
import cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.exception.FruitNotFoundException;
import cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.model.repository.FruitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService implements IFruitServices {

    @Autowired
    private  FruitRepo fruitRepo;

    @Override
    public Fruit addFruit(Fruit fruit) {
        return fruitRepo.save(fruit);
    }

    @Override
    public Fruit updateFruitById(int id, Fruit newFruitData) {
        Optional<Fruit> oldFruitData = fruitRepo.findById(id);
        if (oldFruitData.isPresent()) {
            Fruit updatedFruit = oldFruitData.get();
            updatedFruit.setName(newFruitData.getName());
            updatedFruit.setKgs(newFruitData.getKgs());

            return fruitRepo.save(updatedFruit);
        } else {
            throw new FruitNotFoundException("Fruit not found with id "+id);
        }

    }

    @Override
    public void deleteFruitById(int id) {
        Fruit fruitFound = fruitRepo.findById(id).orElseThrow(() -> new FruitNotFoundException("Fruit not found with id "+id));

        fruitRepo.deleteById(fruitFound.getId());
    }

     @Override
    public Fruit getFruitById(int id) {
        return fruitRepo.findById(id).orElseThrow(() -> new FruitNotFoundException("Fruit not found with id "+id));

    }

    @Override
    public List<Fruit> getAllFruits() {
        return fruitRepo.findAll();
    }

}
