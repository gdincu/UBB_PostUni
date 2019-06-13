package Domain;

public class Booking {

    private int bookingID, nrGuests, roomID, nrDays, rating;
    private String feedback;
    private boolean leftService;

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getNrGuests() {
        return nrGuests;
    }

    public void setNrGuests(int nrGuests) {
        this.nrGuests = nrGuests;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getNrDays() {
        return nrDays;
    }

    public void setNrDays(int nrDays) {
        this.nrDays = nrDays;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public boolean isLeftService() {
        return leftService;
    }

    public void setLeftService(boolean leftService) {
        this.leftService = leftService;
    }

    public Booking(int bookingID, int nrGuests, int roomID, int nrDays, int rating, String feedback, boolean leftService) {
        this.bookingID = bookingID;
        this.nrGuests = nrGuests;
        this.roomID = roomID;
        this.nrDays = nrDays;
        this.rating = rating;
        this.feedback = feedback;
        this.leftService = leftService;
    }

    public Booking(int bookingID) {
        this(bookingID,0,0,0,0,"",false);
    }
}
