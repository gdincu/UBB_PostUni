package Domain;
import Service.ServiceException;
import java.text.*;

public class FacturaValidator implements IValidator<Factura> {

    /**
     * Validates a receipt
     * @param factura factura ce trebuie validata
     */
    public void validate(Factura factura) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        String errors = "";

        try {
            format.parse(factura.getDate());
        } catch (ParseException pe) {
            errors += "Date is an incorrect format - should be dd.mm.yyyy" + "\n";
        }

        if (!errors.isEmpty())
            throw new ServiceException(errors);
    }
}
