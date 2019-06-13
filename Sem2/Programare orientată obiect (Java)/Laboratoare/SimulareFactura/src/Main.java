import Domain.*;
import Repository.*;
import Service.FacturaService;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import UI.MainController;

public class Main extends Application {

    @Override
    public void start(Stage newStage) throws Exception{

        IValidator<Factura> receiptValidator = new FacturaValidator();
        IRepository<Factura> receiptRepository = new InMemoryRepository<>(receiptValidator);
        FacturaService receiptService = new FacturaService(receiptRepository);


        // Adds a few random transactions
        receiptService.addReceipt(1,22.3,"Description1","12.12.2012");
        receiptService.addReceipt(2,23.5,"Description2","11.11.2011");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = fxmlLoader.load();
        MainController mainController = fxmlLoader.getController();
        mainController.setServices(receiptService);

        newStage.setTitle("Receipt Manager v1.0");
        newStage.setScene(new Scene(root, 330, 575));
        newStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}