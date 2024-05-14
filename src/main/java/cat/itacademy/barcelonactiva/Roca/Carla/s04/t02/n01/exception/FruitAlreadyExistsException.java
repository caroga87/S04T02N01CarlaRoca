package cat.itacademy.barcelonactiva.Roca.Carla.s04.t02.n01.exception;

public class FruitAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FruitAlreadyExistsException(String msg)
    {
        super(msg);
    }
}
