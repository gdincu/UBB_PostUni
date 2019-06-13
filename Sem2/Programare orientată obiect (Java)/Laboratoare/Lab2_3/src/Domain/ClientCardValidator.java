package Domain;
import Service.ServiceException;

import java.text.*;

public class ClientCardValidator implements IValidator<ClientCard> {

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
            errors += "CNP needs to be longer!\n";


        if (!errors.isEmpty())
            throw new ServiceException(errors);
    }
}