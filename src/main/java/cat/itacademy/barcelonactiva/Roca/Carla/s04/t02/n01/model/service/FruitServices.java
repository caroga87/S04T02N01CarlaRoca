package cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.model.service;

import cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.exception.FruitAlreadyExistsException;
import cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.exception.FruitNotFoundException;
import cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.model.repository.FruitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServices implements IFruitServices {

    @Autowired
    private final FruitRepo fruitRepo;

    public FruitServices(FruitRepo fruitRepo) {
        this.fruitRepo = fruitRepo;
    }


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
            throw new FruitNotFoundException("Fruit with Id " + id + " is not found");
        }

    }

    @Override
    public void deleteFruitById(int id) {
        Fruit fruitFound = fruitRepo.findById(id).orElseThrow(() -> new FruitNotFoundException("Fruit with Id " + id + " is not found"));

        fruitRepo.deleteById(fruitFound.getId());
    }

    //getFruitById is @Deprecated //use findById() instead
    @Override
    public Fruit getFruitById(int id) {
        return fruitRepo.findById(id).orElseThrow(() -> new FruitNotFoundException("Fruit with Id " + id + " is not found"));

    }

    @Override
    public List<Fruit> getAllFruits() {
        return (List<Fruit>) fruitRepo.findAll();
    }

}
