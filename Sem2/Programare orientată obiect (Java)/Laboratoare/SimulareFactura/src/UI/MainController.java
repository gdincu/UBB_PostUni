package UI;
import Domain.Factura;
import Service.FacturaService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class MainController {

    public TableColumn colReceipt;
    public TableView<Factura> tblReceipt;
    public TableColumn colReceiptId;
    public TableColumn colReceiptPrice;
    public TableColumn colReceiptDescription;
    public TableColumn colReceiptDate;
    public TextField txtReceiptId;
    public TextField txtReceiptPrice;
    public TextField txtReceiptDescription;
    public TextField txtReceiptDate;
    public Button btnAddReceipt;
    public Button btnRemoveReceipt;
    public Button btnSearchAllReceipt;

    private FacturaService receiptService;
    private ObservableList<Factura> receipt = FXCollections.observableArrayList();

    public void setServices(FacturaService receiptService) {
        this.receiptService = receiptService;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            receipt.addAll(receiptService.getAll());
            tblReceipt.setItems(receipt);
        });
    }

    public void btnAddAndUpdateReceiptClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtReceiptId.getText());
            double price = Double.parseDouble(txtReceiptPrice.getText());
            String description = txtReceiptDescription.getText();
            String date = txtReceiptDate.getText();

            receiptService.addReceipt(id, price, description, date);

            receipt.clear();
            receipt.addAll(receiptService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnRemoveReceiptClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtReceiptId.getText());
            receiptService.removeReceipt(id);

            receipt.clear();
            receipt.addAll(receiptService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnGetAllReceiptClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtReceiptId.getText());
            double price = Double.valueOf(txtReceiptPrice.getText());
            String description = txtReceiptDescription.getText();
            String date = txtReceiptDate.getText();

            receiptService.getAll();

            receipt.clear();
            receipt.addAll(receiptService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void setBtnSearchAllReceipt(ActionEvent actionEvent) {

        String text = "";
        try {
            int id = Integer.parseInt(txtReceiptId.getText());
            text += String.valueOf(id);
            double price = Double.valueOf(txtReceiptPrice.getText());
            text += String.valueOf(price);
            String description = txtReceiptDescription.getText();
            text += description;
            String date = txtReceiptDate.getText();
            text += date;

            receipt.clear();
            List<Factura> temp = receiptService.fullTextSearch(text);
            for (Factura c : temp)
                receipt.add(c);

        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }

    }
}