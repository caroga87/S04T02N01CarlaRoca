package cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.exception;

public class FruitNotFoundException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    public FruitNotFoundException(int id) {
        super("Fruit not found with id "+id);
    }
}

