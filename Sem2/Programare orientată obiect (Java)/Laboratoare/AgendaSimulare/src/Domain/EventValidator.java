package Domain;
import Service.ServiceException;
import java.text.*;

public class EventValidator implements IValidator<Event> {

    /**
     * Validates an event
     * @param event the event that needs to be validated
     */
    public void validate(Event event) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        String errors = "";

        try {
            format.parse(event.getDate());
        } catch (ParseException pe) {
            errors += "Date is an incorrect format - should be dd/mm/yyyy" + "\n";
        }

        if (!errors.isEmpty())
            throw new ServiceException(errors);
    }
}
