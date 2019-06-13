package Domain;

import Service.DieselService;

public class DieselValidator implements IValidator<DieselCar> {

    @Override
    public void validate(DieselCar A) {
        if(A.getPret() <= 0) throw new RuntimeException("PRetul trebuie sa fie pozitiv!");
    }
}
