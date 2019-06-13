package UI;
import Domain.RoomReportViewModel;
import Service.BookingService;
import java.util.*;

public class Console {

    private BookingService service;
    private Scanner in = new Scanner(System.in);

    public Console(BookingService service) {
        this.service = service;
    }

    private void showMenu() {
        System.out.println("\n1. Add booking.");
        System.out.println("2. End booking.");
        System.out.println("3. Show ratings report.");
        System.out.println("0. Exit.");
        System.out.print("Your option: ");
    }

    private void handleEntry() {
        System.out.print("\nEntry id: ");
        int bookingID = in.nextInt();
        System.out.print("Room number: ");
        int roomID = in.nextInt();
        System.out.print("Nr. of guests: ");
        int nrGuests=in.nextInt();
        System.out.print("Number of days: ");
        int nrDays = in.nextInt();
        System.out.println();

        try {
            service.startBooking(bookingID, nrGuests, roomID, nrDays,0,"",false);
            System.out.println("Booking started!");
        } catch (RuntimeException rex) {
            System.out.println("We have errors:");
            System.out.println(rex.getMessage());
        }
    }

    private void handleExit() {
        System.out.print("\nRoom id: ");
        int bookingID = in.nextInt();
        System.out.print("Rating: ");
        int rating = in.nextInt();
        System.out.print("Feedback: ");
        String feedback=new Scanner(System.in).nextLine();
        System.out.println();

        try {
            service.endBooking(bookingID, rating, feedback);
            System.out.println("Booking ended!");
            System.out.println();
        } catch (RuntimeException rex) {
            System.out.println("We have errors:");
            System.out.println(rex.getMessage());
            System.out.println();
        }
    }

    private void handleReport() {

        List<RoomReportViewModel> roomReports = service.getRoomsReport();
        System.out.println("\nRooms Average Ratings\n-----------------------------");
        for (RoomReportViewModel roomReport : roomReports) {
            System.out.println(String.format("Room: %d - Average Rating: %f", roomReport.getRoomID(), roomReport.getRatingAverage()));
        }
    }

    public void run() {

        while (true) {
            showMenu();

            int option = in.nextInt();
            if (option == 1) {
                handleEntry();
            } else if (option == 2) {
                handleExit();
            } else if (option == 3) {
                handleReport();
            } else if (option == 0) {
                break;
            } else {
                System.out.println("Invalid option!");
            }
        }
    }

}
