package UI;

import Domain.ClientCard;
import Domain.Drug;
import Domain.Transaction;
import Service.ClientCardService;
import Service.DrugService;
import Service.TransactionService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainController {

    public TableView<Drug> tblDrug;
    public TextField txtDrugId;
    public TextField txtDrugName;
    public TextField txtDrugProducer;
    public TextField txtDrugPrice;
    public CheckBox chkDrugRecipe;
    public TextField txtDrugMinPrice;
    public TextField txtPctIncrease;

    public TableView tblClient;
    public TextField txtClientId;
    public TextField txtClientSurname;
    public TextField txtClientForename;
    public TextField txtClientCNP;
    public TextField txtClientDateOfBirth;
    public TextField txtClientDateOfRegistration;

    public TableView tblTransaction;
    public TextField txtTransactionId;
    public TextField txtTransactionIdMedicine;
    public TextField txtTransactionIdClientCard;
    public TextField txtTransactionNumberMedicine;
    public TextField txtTransactionDate;
    public TextField txtTransactionHour;
    public TextField txtStartDate;
    public TextField txtEndDate;


    private DrugService drugService;
    private ClientCardService clientService;
    private TransactionService transactionService;

    private ObservableList<Drug> drug = FXCollections.observableArrayList();
    private ObservableList<ClientCard> client = FXCollections.observableArrayList();
    private ObservableList<Transaction> transaction = FXCollections.observableArrayList();

    public void setServices(DrugService drugService, ClientCardService clientService, TransactionService transactionService) {
        this.drugService = drugService;
        this.clientService = clientService;
        this.transactionService = transactionService;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            drug.addAll(drugService.getAll());
            tblDrug.setItems(drug);
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

    /*Functions for drugs*/
    /**
     * Adds/ Updates drugs
     * @param actionEvent
     */
    public void btnAddAndUpdateDrugClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtDrugId.getText());
            String name = txtDrugName.getText();
            String producer = txtDrugProducer.getText();
            int price = Integer.parseInt(txtDrugPrice.getText());
            boolean recipe = chkDrugRecipe.isSelected();

            drugService.addDrug(id, price, name, producer, recipe);

            drug.clear();
            drug.addAll(drugService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    /**
     * Used to remove drugs based on user input
     * @param actionEvent
     */
    public void btnRemoveDrugClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtDrugId.getText());
            drugService.removeDrug(id);

            drug.clear();
            drug.addAll(drugService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    /**
     * Used to search for drugs based on user input
     *
     * @param actionEvent
     */
    public void setBtnSearchAllDrugs(ActionEvent actionEvent) {

        String text = "";
        try {
            text += txtDrugId.getText();
            text += txtDrugName.getText();
            text += txtDrugProducer.getText();
            text += txtDrugPrice.getText();

            drug.clear();
            for (Drug c : drugService.fullTextSearch(text))
                drug.add(c);

        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    /**
     * Used to refresh the drug list
     * @param actionEvent
     */
    public void setBtnGetAllDrugs(ActionEvent actionEvent) {
        try {
            drug.clear();
            drug.addAll(drugService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    /**
     * Used to increase the price of certain drugs
     *
     * @param actionEvent
     */
    public void setBtnIncreasePrice(ActionEvent actionEvent) {
        int minPrice = Integer.parseInt(txtDrugMinPrice.getText());
        int increase = Integer.parseInt(txtPctIncrease.getText());

        drugService.IncreasePrice(minPrice, increase);

        drug.clear();
        drug.addAll(drugService.getAll());
    }

    /**
     * Used to order drugs by sales
     */
    public void OrderDrugsBySales() {

        drug.clear();
        List<Drug> temp = drugService.sortDrugsBySales();
        drug.addAll(temp);
    }

    /**
     * Functions for client cards
     * */
    public void btnAddAndUpdateClientClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtClientId.getText());
            String surname = txtClientSurname.getText();
            String forename = txtClientForename.getText();
            String CNP = txtClientCNP.getText();
            String dateOfBirth = txtClientDateOfBirth.getText();
            String dateOfRegistration = txtClientDateOfRegistration.getText();

            clientService.addClientCard(id,CNP,surname,forename,dateOfBirth,dateOfRegistration);

            client.clear();
            client.addAll(clientService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnRemoveClientClick(ActionEvent actionEvent) {
        try {
            int id = Integer.parseInt(txtClientId.getText());
            String name = txtClientSurname.getText();
            String firstName = txtClientForename.getText();
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

    public void btnSearchAllClientsClick(ActionEvent actionEvent) {

        String text = "";
        try {
            text += txtClientId.getText();

            client.clear();
            for (ClientCard c : clientService.fullTextSearch(text))
                client.add(c);

        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }

    }

    public void btnGetAllClientsClick(ActionEvent actionEvent) {
        try {
            client.clear();
            client.addAll(clientService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void OrderClientsByDiscounts() {

        client.clear();
        List<ClientCard> temp = clientService.sortClientsByDiscounts();
        client.addAll(temp);

    }

    /**
     * Functions for Transactions
     */
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

            transactionService.removeTransaction(id);

            transaction.clear();
            transaction.addAll(transactionService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnRemoveTransactionByDateClick(ActionEvent actionEvent) {
        try {
            Date start = new SimpleDateFormat("dd/MM/yyyy").parse(txtStartDate.getText());
            Date end = new SimpleDateFormat("dd/MM/yyyy").parse(txtEndDate.getText());

            for (Transaction c : transactionService.getAll()) {
                Date temp = new SimpleDateFormat("dd/MM/yyyy").parse(c.getDate());
                if (temp.compareTo(start) >= 0 && temp.compareTo(end) < 0)
                    transactionService.removeTransaction(c.getId());
            }

            transaction.clear();
            transaction.addAll(transactionService.getAll());
        } catch (RuntimeException | ParseException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnFilterTransactionByDateClick() {
        try {
            Date start = new SimpleDateFormat("dd/MM/yyyy").parse(txtStartDate.getText());
            Date end = new SimpleDateFormat("dd/MM/yyyy").parse(txtEndDate.getText());

            transaction.clear();

            for (Transaction c : transactionService.getAll()) {
                Date temp = new SimpleDateFormat("dd/MM/yyyy").parse(c.getDate());
                if (temp.compareTo(start) >= 0 && temp.compareTo(end) < 0)
                    transaction.add(c);
            }

        } catch (RuntimeException | ParseException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnGetAllTransactionsClick(ActionEvent actionEvent) {
        try {
            transaction.clear();
            transaction.addAll(transactionService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnAverageTransactionClick(ActionEvent actionEvent) {
        int sum = 0, count = transactionService.getAll().size();
        for (Transaction c : transactionService.getAll())
            sum += c.getPrice();

        try {
            transaction.clear();
            for (Transaction c : transactionService.getAll())
                if (c.getPrice() > (sum / count))
                    transaction.add(c);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }
}