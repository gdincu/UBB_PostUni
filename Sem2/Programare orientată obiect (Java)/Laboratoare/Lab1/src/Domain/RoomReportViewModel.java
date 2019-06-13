package Domain;

public class RoomReportViewModel {
    private int roomID;
    private double ratingAverage;

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public double getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(double ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public RoomReportViewModel(int roomID, double ratingAverage) {
        this.roomID = roomID;
        this.ratingAverage = ratingAverage;
    }
}
