package Domain;

public class BookingValidator implements IValidator<Booking> {

    /**
     * Validates a client card
     * @param booking the car to be validated
     * Raises RuntimeException if there are validation errors.
     */
    public void validate(Booking booking) {

        if(booking.getKm() < 0) throw new BookingException("KM trebuie sa fie >= 0!");
        if(booking.getDays() < 1) throw new BookingException("Nr de zile trebuie sa fie >= 1!");
    }

}
