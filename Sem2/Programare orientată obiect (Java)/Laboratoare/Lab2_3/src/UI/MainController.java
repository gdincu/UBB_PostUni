package UI;
import Domain.*;
import Service.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    public TableColumn colMedicine;
    public TableView<Drug> tblMedicine;
    public TableColumn colMedicineName;
    public TableColumn colMedicineFirstName;
    public TableColumn colMedicineProducer;
    public TableColumn colMedicinePrice;
    public TableColumn colMedicineRecipe;
    public TextField txtMedicineId;
    public TextField txtMedicineName;
    public TextField txtMedicineFirstName;
    public TextField txtMedicineProducer;
    public TextField txtMedicinePrice;
    public CheckBox chkMedicineRecipe;
    public Button btnAddAndUpdateMedicine;
    public Button btnRemoveMedicine;
    public Button btnGetAllMedicine;
    public TableView tblClient;
    public TableColumn colClient;
    public TableColumn colClientName;
    public TableColumn colClientFirstName;
    public TableColumn colClientCNP;
    public TableColumn colClientDateOfBirth;
    public TableColumn colClientDateOfRegistration;
    public TextField txtClientId;
    public TextField txtClientName;
    public TextField txtClientFirstName;
    public TextField txtClientCNP;
    public TextField txtClientDateOfBirth;
    public TextField txtClientDateOfRegistration;
    public Button btnAddAndUpdateClient;
    public Button btnRemoveClient;
    public Button btnGetAllClient;
    public TableView tblTransaction;
    public TableColumn colTransaction;
    public TableColumn colTransactionIdMedicine;
    public TableColumn colTransactionIdClientCard;
    public TableColumn colTransactionNumberMedicine;
    public TableColumn colTransactionDate;
    public TableColumn colTransactionHour;
    public TextField txtTransactionId;
    public TextField txtTransactionIdMedicine;
    public TextField txtTransactionIdClientCard;
    public TextField txtTransactionNumberMedicine;
    public TextField txtTransactionDate;
    public TextField txtTransactionHour;
    public Button btnAddAndUpdateTransaction;
    public Button btnRemoveTransaction;
    public Button btnGetAllTransaction;

    private DrugService medicineService;
    private ClientCardService clientService;
    private TransactionService transactionService;

    private ObservableList<Drug> medicine = FXCollections.observableArrayList();
    private ObservableList<ClientCard> client = FXCollections.observableArrayList();
    private ObservableList<Transaction> transaction = FXCollections.observableArrayList();

    public void setServices(DrugService medicineService, ClientCardService clientService, TransactionService transactionService) {
        this.medicineService = medicineService;
        this.clientService = clientService;
        this.transactionService = transactionService;
    }

    @FXML


    private void initialize() {

        Platform.runLater(() -> {
            medicine.addAll(medicineService.getAll());
            tblMedicine.setItems(medicine);
        });

        Platform.runLater(() -> {
            client.addAll(clientService.getAll());
            tblClient.setItems(client);
        });

        Platform.runLater(() -> {
            transaction.addAll(transactionService.getAll());
            tblTransaction.setItems(transaction);
        });

    }

    public void btnAddAndUpdateMedicineClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtMedicineId.getText());
            String name = txtMedicineName.getText();
            String producer = txtMedicineProducer.getText();
            int price = Integer.parseInt(txtMedicinePrice.getText());
            boolean recipe = chkMedicineRecipe.isSelected();

            medicineService.addDrug(id, price, name, producer, recipe);

            medicine.clear();
            medicine.addAll(medicineService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnRemoveMedicineClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtMedicineId.getText());
            String name = txtMedicineName.getText();
            String firstName = txtMedicineFirstName.getText();
            String producer = txtMedicineProducer.getText();
            double price = Double.parseDouble(txtMedicinePrice.getText());
            boolean recipe = chkMedicineRecipe.isSelected();

            medicineService.removeDrug(id);

            medicine.clear();
            medicine.addAll(medicineService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnGetAllMedicinesClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtMedicineId.getText());
            String name = txtMedicineName.getText();
            String firstName = txtMedicineFirstName.getText();
            String producer = txtMedicineProducer.getText();
            double price = Double.parseDouble(txtMedicinePrice.getText());
            boolean recipe = chkMedicineRecipe.isSelected();

            medicineService.getAll();

            medicine.clear();
            medicine.addAll(medicineService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnAddAndUpdateClientClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtClientId.getText());
            String name = txtClientName.getText();
            String firstName = txtClientFirstName.getText();
            String CNP = txtClientCNP.getText();
            String dateOfBirth = txtClientDateOfBirth.getText();
            String dateOfRegistration = txtClientDateOfRegistration.getText();

            clientService.addClientCard(id, name, firstName, CNP, dateOfBirth, dateOfRegistration);

            client.clear();
            client.addAll(clientService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnRemoveClientClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtClientId.getText());
            String name = txtClientName.getText();
            String firstName = txtClientFirstName.getText();
            String CNP = txtClientCNP.getText();
            String dateOfBirth = txtClientDateOfBirth.getText();
            String dateOfRegistration = txtClientDateOfRegistration.getText();

            clientService.removeClientCard(id);

            client.clear();
            client.addAll(clientService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnGetAllClientsClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtClientId.getText());
            String name = txtClientName.getText();
            String firstName = txtClientFirstName.getText();
            String CNP = txtClientCNP.getText();
            String dateOfBirth = txtClientDateOfBirth.getText();
            String dateOfRegistration = txtClientDateOfRegistration.getText();

            clientService.getAll();

            client.clear();
            client.addAll(clientService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }
    public void btnAddAndUpdateTransactionClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtTransactionId.getText());
            int idMedicine = Integer.parseInt(txtTransactionIdMedicine.getText());
            int idClientCard = Integer.parseInt(txtTransactionIdClientCard.getText());
            int numberMedicine = Integer.parseInt(txtTransactionNumberMedicine.getText());
            String date = txtTransactionDate.getText();
            String hour = txtTransactionHour.getText();

            transactionService.addTransaction(id, idMedicine, idClientCard, numberMedicine, date, hour);

            transaction.clear();
            transaction.addAll(transactionService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnRemoveTransactionClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtTransactionId.getText());
            int idMedicine = Integer.parseInt(txtTransactionIdMedicine.getText());
            int idClientCard = Integer.parseInt(txtTransactionIdClientCard.getText());
            int numberMedicine = Integer.parseInt(txtTransactionNumberMedicine.getText());
            String date = txtTransactionDate.getText();
            String hour = txtTransactionHour.getText();

            transactionService.removeTransaction(id);

            transaction.clear();
            transaction.addAll(transactionService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnGetAllTransactionsClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtTransactionId.getText());
            int idMedicine = Integer.parseInt(txtTransactionIdMedicine.getText());
            int idClientCard = Integer.parseInt(txtTransactionIdClientCard.getText());
            int numberMedicine = Integer.parseInt(txtTransactionNumberMedicine.getText());
            String date = txtTransactionDate.getText();
            String hour = txtTransactionHour.getText();

            transactionService.getAll();

            transaction.clear();
            transaction.addAll(transactionService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

}