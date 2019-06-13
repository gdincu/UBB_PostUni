package Service;
import Domain.Booking;
import Domain.RoomReportViewModel;
import Repository.BookingRepository;
import java.util.*;

public class BookingService {

    private BookingRepository repository;

    /**
     * Instantiates a booking service.
     * @param repository the repository used by this service.
     */
    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    /**
     * Adds a booking to the bookings list.
     * @param bookingID the booking id.
     * @param roomID the room number.
     * @param nrGuests the number of guests.
     * @param nrDays the number of days.
     * @param rating the rating for the booking.
     * @param feedback the feedback for the booking.
     * @param leftService boolean to show whether booking has ended.
     * Raises RuntimeException if the stand number is taken of there are other errors.
     */

    public void startBooking(int bookingID, int nrGuests, int roomID, int nrDays, int rating, String feedback, boolean leftService) {

        // Checking whether the roomID is available
        for (Booking c : repository.getAll()) {
            if (c.getRoomID() == roomID && !c.isLeftService()) {
                throw new RuntimeException("That room is already used for another booking!");
            }
        }
        Booking booking = new Booking(bookingID, nrGuests, roomID, nrDays,rating,feedback,leftService);
        repository.add(booking);
    }

    /**
     * Removes a booking from the bookings list.
     * @param roomID the booking ID to be deleted.
     * Raises RuntimeException if the bookingID number is empty.
     */
    public void endBooking(int roomID, int rating, String feedback) {

        if(rating < 1 || rating > 5) throw new RuntimeException("The rating should be between 1 and 5!");
        if(feedback.length() <= 0) throw new RuntimeException("Feedback is required!");

        for (Booking c : repository.getAll()) {
            if (c.getRoomID() == roomID) {
                c.setFeedback(feedback);
                c.setRating(rating);
                c.setLeftService(true);
                repository.update(c);
                return;
            }
        }
        throw new RuntimeException("There is no booking for that room ID!");
    }

    /**
     * @return A list of view models ordered descendingly by average stand prices.
     */
    public List<RoomReportViewModel> getRoomsReport() {

        // Grouping the ratings by roomID
        Map<Integer, List<Integer>> roomGroups = new HashMap<>();
        for (Booking c : repository.getAll()) {
              if (c.isLeftService()) {
                int roomNumber = c.getRoomID();
                if (roomGroups.containsKey(roomNumber)) {
                    roomGroups.get(roomNumber).add(c.getRating());
                } else {
                    List<Integer> firstPrice = new ArrayList<>();
                    firstPrice.add(c.getRating());
                    roomGroups.put(roomNumber, firstPrice);
                }
            }
        }

        List<RoomReportViewModel> result = new ArrayList<>();
        for (Integer roomID : roomGroups.keySet()) {
            double average = 0;
            for (int rating : roomGroups.get(roomID)) {
                average += rating;
            }
            average /= roomGroups.get(roomID).size();

            result.add(new RoomReportViewModel(roomID, average));
        }

        result.sort((v1, v2) -> v1.getRatingAverage() > v2.getRatingAverage() ? -1 : 0);
        return result;
    }

}
