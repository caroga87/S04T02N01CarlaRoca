package cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FruitRepo extends JpaRepository<Fruit, Integer> {
    Optional<Fruit> findByNameIgnoreCase(String name);
}
