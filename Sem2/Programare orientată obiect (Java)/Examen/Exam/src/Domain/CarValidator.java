package Domain;

public class CarValidator implements IValidator<Car> {

    /**
     * Validates a client card
     * @param car the car to be validated
     * Raises RuntimeException if there are validation errors.
     */
    public void validate(Car car) {

        if(car.getPret() <= 0) throw new CarPriceException("Pretul trebuie sa fie pozitiv!");

    }
}
