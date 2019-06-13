package Domain;

public class ElectricValidator implements IValidator<ElectricCar> {

    @Override
    public void validate(ElectricCar A) {
        if(A.getPret() <= 0) throw new RuntimeException("Pretul trebuie sa fie pozitiv!");
    }
}
