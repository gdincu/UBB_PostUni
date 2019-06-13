import Domain.*;
import Repository.FileRepository;
import Repository.IRepository;
import Service.BookingService;
import Service.CarService;
import UI.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage newStage) throws Exception{

        IValidator<Car> carIValidator = new CarValidator();
        IRepository<Car> carFileRepository= new FileRepository<>(carIValidator, "/cars.json", Car[].class);
        CarService carService = new CarService(carFileRepository);

        IValidator<Booking> bookingIValidator = new BookingValidator();
        IRepository<Booking> bookingIRepository= new FileRepository<>(bookingIValidator, "/bookings.json", Booking[].class);
        BookingService bookingService = new BookingService(bookingIRepository, carFileRepository);

//        carService.addOrUpdate("100","M1",12,13);
//        carService.addOrUpdate("120","M1",12,13);
//        bookingService.addOrUpdate("1","100",2,2);
//        bookingService.addOrUpdate("2","100",2,2);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindows.fxml"));
        Parent root = fxmlLoader.load();
        Controller mainController = fxmlLoader.getController();

        mainController.setServices(carService,bookingService);
        newStage.setTitle("Service Auto");
        newStage.setScene(new Scene(root, 700, 700));
        newStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

