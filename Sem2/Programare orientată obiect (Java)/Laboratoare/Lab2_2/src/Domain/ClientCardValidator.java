package Domain;
import Service.ServiceException;

import java.text.*;

public class ClientCardValidator implements IValidator<ClientCard> {

    boolean isPrim(int n) {
        for(int i=2;i*i<n;i++)
            if(n%i == 0) return true;
        return false;
    }

    /**
     * Validates a client card
     * @param clientCard the client card to be validated
     * Raises RuntimeException if there are validation errors.
     */
    public void validate(ClientCard clientCard) {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        String errors = "";

        try {
            format.parse(clientCard.getDOB().toString());
        } catch (ParseException pe) {
            errors += pe.getMessage() + "\n";
        }

        try {
            format.parse(clientCard.getRegDate().toString());
        } catch (ParseException pe) {
            errors += pe.getMessage() + "\n";
        }

        if (clientCard.getCNP().length() < 13)
            errors += "CNP needs to be 13 digits long!\n";

        if(isPrim(clientCard.getId())) throw new ServiceException("The Client Card ID needs to be a prime number!");

        if (!errors.isEmpty())
            throw new ServiceException(errors);
    }
}