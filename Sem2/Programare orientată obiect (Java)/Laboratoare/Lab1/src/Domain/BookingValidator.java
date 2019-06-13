package Domain;

public class BookingValidator {

    /**
     * Validates a booking
     * @param booking
     */
    public void validate(Booking booking) {

        String errors = "";
        if (booking.getNrGuests() == 0) {
            errors += "The room is already full. A valid room needs to be selected!\n";
        }

        if (booking.getNrDays() <= 0) {
            errors += "The nr. of days needs to be positive!\n";
        }

        if (!errors.equals("")) {
            throw new RuntimeException(errors);
        }
    }
}