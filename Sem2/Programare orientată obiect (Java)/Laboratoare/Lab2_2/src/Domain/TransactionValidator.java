package Domain;
import Service.ServiceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TransactionValidator implements IValidator<Transaction> {

    boolean isPrim(int n) {
        for(int i=2;i*i<n;i++)
            if(n%i == 0) return true;
        return false;
    }

    /**
     * Validates a transaction
     * @param transaction the transaction to be validated.
     * Raises RuntimeException if there are validation errors.
     */
    public void validate(Transaction transaction) {

        String errors = "";
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm");

        try {
            formatDate.parse(transaction.getDate());
        } catch (ParseException pe) {
            errors += "The transaction date is not in a correct format!";
        }

        try {
            formatTime.parse(transaction.getTime());
        } catch (ParseException pe) {
            errors += "The transaction time is not in a correct format!";
        }

        if(transaction.getQuantity() <= 0)
            errors += "The quantity need to be strictly positive!";

        if(isPrim(transaction.getId())) throw new ServiceException("The Transaction ID needs to be a prime number!");

        if(!errors.isEmpty())
            throw new ServiceException(errors);
    }
}