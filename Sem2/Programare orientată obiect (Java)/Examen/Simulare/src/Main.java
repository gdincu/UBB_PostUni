import Domain.*;
import Repository.FileRepository;
import Repository.IRepository;
import Service.DieselService;
import Service.ElectricService;
import UI.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage newStage) throws Exception{

        IValidator<DieselCar> dieselValidator = new DieselValidator();
        IRepository<DieselCar> dieselCarRepository= new FileRepository<>(dieselValidator, "diesels.json", DieselCar[].class);
        DieselService dieselService = new DieselService(dieselCarRepository);

        IValidator<ElectricCar> electricValidator = new ElectricValidator();
        IRepository<ElectricCar> electricCarRepository= new FileRepository<>(electricValidator, "electrics.json", ElectricCar[].class);
        ElectricService electricService = new ElectricService(electricCarRepository);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = fxmlLoader.load();
        Controller mainController = fxmlLoader.getController();
        mainController.setServices(dieselService,electricService);
        newStage.setTitle("Service Auto");
        newStage.setScene(new Scene(root, 700, 700));
        newStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
