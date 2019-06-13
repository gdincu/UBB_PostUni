package Domain;

import Service.ServiceException;

public class DrugValidator implements IValidator<Drug> {
    /**
     * Validates a drug
     * @param drug the drug to validate
     * Raises RuntimeException if there are validation errors.
     */

    public void validate(Drug drug) {
        String errors = "";
        if(drug.getPrice() <= 0) errors += "The price needs to be strictly positive";
        if(!errors.isEmpty()) throw new ServiceException(errors);
    }
}