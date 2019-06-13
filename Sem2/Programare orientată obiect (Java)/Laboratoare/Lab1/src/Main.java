import Domain.BookingValidator;
import Repository.BookingRepository;
import Service.BookingService;
import UI.Console;
public class Main {


public static void main(String[] args) {

        BookingValidator bookingValidator = new BookingValidator();
        BookingRepository bookingRepository = new BookingRepository(bookingValidator);
        BookingService bookingService = new BookingService(bookingRepository);
        Console console = new Console(bookingService);
        console.run();
    }
}
