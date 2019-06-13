import Domain.*;
import Repository.*;
import Service.*;
import UI.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
            Parent root = fxmlLoader.load();


        IValidator<Drug> drugValidator = new DrugValidator();
        IRepository<Drug> drugRepository = new InMemoryRepository<>(drugValidator);
        DrugService drugService = new DrugService(drugRepository);

        IValidator<ClientCard> clientCardValidator = new ClientCardValidator();
        IRepository<ClientCard> clientCardRepository = new InMemoryRepository<>(clientCardValidator);
        ClientCardService clientCardService = new ClientCardService(clientCardRepository);

        IValidator<Transaction> transactionValidator = new TransactionValidator();
        IRepository<Transaction> transactionRepository = new InMemoryRepository<>(transactionValidator);
        TransactionService transactionService = new TransactionService(transactionRepository,drugRepository,clientCardRepository);



        // Adds a few random drugs
        drugService.addDrug(100,12,"Med1","Prod1",true);
        drugService.addDrug(101,37,"Med2","Prod1",false);
        drugService.addDrug(102,98,"Med3","Prod2",true);
        drugService.addDrug(103,22,"Med4","Prod3",true);
        drugService.addDrug(104,75,"Med5","Prod1",false);

        // Adds a few random Client Cards
        clientCardService.addClientCard(100,"1990930160043","Ionescu","Ion","12/12/2012","13/12/2012");
        clientCardService.addClientCard(101,"2940930160043","Popesc","Ioana","11/11/2011","13/12/2012");
        clientCardService.addClientCard(102,"1900930160043","Vlad","Diana","10/10/2010","13/12/2012");
        clientCardService.addClientCard(103,"2920930160043","Ciobanu","Mihaita","09/12/2009","13/12/2012");
        clientCardService.addClientCard(104,"1070930160043","Ionescu","Vasile","12/12/2009","13/12/2012");

        // Adds a few random transactions
        transactionService.addTransaction(100,100,100,10,"15/12/2012","22:20");

//        Console console = new Console(drugService, clientCardService,transactionService);
//        console.run();
//        console.allInOneInput();

        MainController mainController = fxmlLoader.getController();
        mainController.setServices(drugService, clientCardService, transactionService);

        primaryStage.setTitle("Online Pharmacy_V1.0");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();
    }

        public static void main(String[] args) {
            launch(args);

        }
}
