import Domain.*;
import Repository.*;
import Service.EventService;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import UI.MainController;

public class Main extends Application {

    @Override
    public void start(Stage newStage) throws Exception{

        IValidator<Event> eventValidator = new EventValidator();
        IRepository<Event> eventRepository = new InMemoryRepository<>(eventValidator);
        EventService eventService = new EventService(eventRepository);

        // Adds a few random events
        eventService.addEvent("1","Ev1","12/12/2012","00:01","00:00");
        eventService.addEvent("3","Ev2","13/12/2012","00:02","00:09");
        eventService.addEvent("5","Ev5","19/12/2012","01:02","00:12");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = fxmlLoader.load();
        MainController mainController = fxmlLoader.getController();
        mainController.setServices(eventService);

        newStage.setTitle("Event Manager v1.0");
        newStage.setScene(new Scene(root, 500, 650));
        newStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}