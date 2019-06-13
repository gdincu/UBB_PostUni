package UI;

import Domain.DieselCar;
import Domain.ElectricCar;
import Service.DieselService;
import Service.ElectricService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;

public class Controller {
    public TableView tableViewDieselCars;
    public TableColumn DieselID;
    public TableColumn DieselModel;
    public TableColumn DieselPret;
    public TableColumn DieselConsum;
    public TextField dieselId;
    public TextField dieselModel;
    public TextField dieselPret;
    public TextField dieselConsum;
    public TextField searchModelDiesel;
    public Button AddDiesel;
    public Button SortDiesel;
    public Button SearchDiesel;
    public Button RefreshDiesel;

    public TableView tableViewElectricCars;
    public TableColumn ElectricID;
    public TableColumn ElectricModel;
    public TableColumn ElectricPret;
    public TableColumn ElectricAutonomie;
    public TextField electricId;
    public TextField electricModel;
    public TextField electricPret;
    public TextField electricAutonomie;
    public TextField searchModelElectric;
    public Button AddElectric;
    public Button SortElectric;
    public Button SearchElectric;
    public Button RefreshElectric;


    private DieselService dieselService;
    private ObservableList<DieselCar> diesels = FXCollections.observableArrayList();

    public void AddDiesel(ActionEvent actionEvent) {
        try {
            String id = dieselId.getText();
            String model = dieselModel.getText();
            double pret = Double.parseDouble(dieselPret.getText());
            double consum = Double.parseDouble(dieselConsum.getText());
            dieselService.add(id,model,pret,consum);

            dieselId.clear();
            dieselModel.clear();
            dieselPret.clear();
            dieselConsum.clear();

            diesels.clear();
            diesels.addAll(dieselService.getAll());

        } catch (RuntimeException ex) {
            Common.showValidationError(ex.getMessage());
        }
    }

    public void setServices(DieselService dieselService, ElectricService electricService) {
        this.dieselService = dieselService;
        this.electricService = electricService;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            diesels.addAll(dieselService.getAll());
            tableViewDieselCars.setItems(diesels);
        });

        Platform.runLater(() -> {
            electrics.addAll(electricService.getAll());
            tableViewElectricCars.setItems(electrics);
        });
    }

    private ElectricService electricService;
    private ObservableList<ElectricCar> electrics = FXCollections.observableArrayList();

    public void AddElectric(ActionEvent actionEvent) {
        try {
            String id = electricId.getText();
            String model = electricModel.getText();
            double pret = Double.parseDouble(electricPret.getText());
            double autonomie = Double.parseDouble(electricAutonomie.getText());
            electricService.add(id,model,pret,autonomie);

            electricId.clear();
            electricModel.clear();
            electricPret.clear();
            electricAutonomie.clear();

            electrics.clear();
            electrics.addAll(electricService.getAll());

        } catch (RuntimeException ex) {
            Common.showValidationError(ex.getMessage());
        }
    }

    public void SortElectric (ActionEvent actionEvent) {

        electrics.clear();
        List<ElectricCar> temp = electricService.sort();
        electrics.addAll(temp);
    }

    public void SortDiesel (ActionEvent actionEvent) {

        diesels.clear();
        List<DieselCar> temp = dieselService.sort();
        diesels.addAll(temp);
    }

    public void RefreshDiesel (ActionEvent actionEvent) {
        diesels.clear();
        diesels.addAll(dieselService.getAll());
    }

    public void RefreshElectric (ActionEvent actionEvent) {
        electrics.clear();
        electrics.addAll(electricService.getAll());
    }

    public void SearchDiesel (ActionEvent actionEvent) {
        diesels.clear();
        String model = searchModelDiesel.getText();
        diesels.addAll(dieselService.cautareModel(model));
    }

    public void SearchElectric (ActionEvent actionEvent) {
        electrics.clear();
        String model = searchModelElectric.getText();
        electrics.addAll(electricService.cautareModel(model));
    }

}