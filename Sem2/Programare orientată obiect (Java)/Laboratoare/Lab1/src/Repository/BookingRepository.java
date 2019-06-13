package Repository;
import Domain.Booking;
import Domain.BookingValidator;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository {

    private List<Booking> bookings = new ArrayList<>();
    private BookingValidator validator;

    /**
     * Instantiates a repository.
     * @param validator the validator used by this repository.
     */
    public BookingRepository(BookingValidator validator) {
        this.validator = validator;
    }

    /**
     * Function to find a booking by its ID
     * @param id the id to look for
     * @returns a booking
     */
    private Booking findById(int id) {
        for (Booking c : bookings) {
            if (c.getBookingID() == id) {
                return c;
            }
        }
        return null;
    }

    /**
     * Adds a booking to the repository
     * @param booking the booking to add
     * Raises RuntimeException if there is already a booking with the given id
     */
    public void add(Booking booking) {
        if (findById(booking.getBookingID()) != null) {
            throw new RuntimeException("A booking with that ID already exists!");
        }
        validator.validate(booking);
        bookings.add(booking);
    }

    /**
     * Updates an existing booking.
     * @param booking the car to be updated.
     * Raises RuntimeException if there is no booking with that id or the new booking fails validation.
     */
    public void update(Booking booking) {
        Booking existingCar = findById(booking.getBookingID());
        if (existingCar == null) {
            throw new RuntimeException("There is no booking with the given ID!");
        }

        validator.validate(booking);
        for (int i = 0; i < bookings.size(); ++i) {
            if (bookings.get(i).getBookingID() == existingCar.getBookingID()) {
                bookings.set(i, booking);
                return;
            }
        }
    }

    /**
     * @return all bookings in the repository.
     */
    public List<Booking> getAll() {
        return bookings;
    }

}