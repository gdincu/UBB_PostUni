package Domain;

import java.util.Objects;

public class Booking extends Entity{

    private String bookingId, carId;
    private int days, km;

    public Booking(String bookingId, String carId, int days, int km) {
        this.bookingId = bookingId;
        this.carId = carId;
        this.days = days;
        this.km = km;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Booking booking = (Booking) o;
        return days == booking.days &&
                km == booking.km &&
                bookingId.equals(booking.bookingId) &&
                carId.equals(booking.carId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bookingId, carId, days, km);
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    /**
     * Used for the full text search functionality
     * @return all details of a booking concatenated into a String
     */
    @Override
    public String toString() {
        return "Booking{" +
                "id='" + getBookingId() + '\'' +
                ", CarId='" + getCarId() + '\'' +
                ", Km='" + getKm() + '\'' +
                ", Days='" + getDays() + '\'' +
                '}';
    }
}
