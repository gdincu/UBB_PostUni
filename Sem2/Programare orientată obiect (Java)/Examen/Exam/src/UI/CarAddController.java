package UI;

import Service.CarService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CarAddController {
    public TextField txtId;
    public TextField txtModel;
    public TextField txtKm;
    public TextField txtPrice;
    public Button btnAdd;
    public Button btnCancel;

    private CarService carService;

    public void setService(CarService carService) {
        this.carService = carService;
    }

    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void btnAddClick(ActionEvent actionEvent) {

        try {
            String id = txtId.getText();
            String Model = txtModel.getText();
            int Km = Integer.parseInt(txtKm.getText());
            Double Price = Double.parseDouble(txtPrice.getText());

            carService.addOrUpdate(id, Model, Km, Price);

            btnCancelClick(actionEvent);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }
}
