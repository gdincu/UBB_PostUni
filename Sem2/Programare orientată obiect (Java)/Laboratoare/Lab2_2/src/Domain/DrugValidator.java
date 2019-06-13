package Domain;

import Service.ServiceException;

public class DrugValidator implements IValidator<Drug> {

    boolean isPrim(int n) {
        for(int i=2;i*i<n;i++)
            if(n%i == 0) return true;
        return false;
    }

    /**
     * Validates a drug
     * @param drug the drug to validate
     * Raises RuntimeException if there are validation errors.
     */
    public void validate(Drug drug) {
        String errors = "";
        if(isPrim(drug.getId())) throw new ServiceException("The Drug ID needs to be a prime number!");
        if(drug.getPrice() <= 0) errors += "The price needs to be strictly positive";
        if(!errors.isEmpty()) throw new ServiceException(errors);
    }
}