package UI;

import Domain.Booking;
import Domain.Car;
import Service.BookingService;
import Service.CarService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {
    public TableView tableViewCars;
    public TableColumn CarId;
    public TableColumn CarModel;
    public TableColumn CarKm;
    public TableColumn CarPrice;

    public TableView tableViewBookings;
    public TableColumn BookingId;
    public TableColumn BookingCarId;
    public TableColumn BookingDays;
    public TableColumn BookingKm;

    public Button btnRaportKm;
    public Button btnRaportVenit;
    public Button btnRaportCerere;

    public TextField txtId;
    public TextField txtModel;
    public TextField txtCarKm;
    public TextField txtCarPrice;
    public Button btnCarAdd;

    public TextField txtBookingId;
    public TextField txtCarId;
    public TextField txtDays;
    public TextField txtKm;
    public Button btnAddBooking;


    private CarService carService;
    private ObservableList<Car> cars = FXCollections.observableArrayList();

    private BookingService bookingService;
    private ObservableList<Booking> bookings = FXCollections.observableArrayList();

    public void setServices(CarService carService, BookingService bookingService) {
        this.carService = carService;
        this.bookingService = bookingService;
    }

    public void AddCar(ActionEvent actionEvent) {
        try {
            String id = txtId.getText();
            String Model = txtModel.getText();
            int Km = Integer.parseInt(txtCarKm.getText());
            Double Price = Double.parseDouble(txtCarPrice.getText());

            carService.addOrUpdate(id, Model, Km, Price);

            cars.clear();
            cars.addAll(carService.getAll());

        } catch (RuntimeException ex) {
            Common.showValidationError(ex.getMessage());
        }
    }

    public void AddBooking(ActionEvent actionEvent) {

        try {
            String bookingId = String.valueOf(txtBookingId.getText());
            String carId = String.valueOf(txtCarId.getText());
            int Km = Integer.parseInt(txtKm.getText());
            int Days = Integer.parseInt(txtDays.getText());

            bookingService.addOrUpdate(bookingId, carId, Km, Days);

            bookings.clear();
            bookings.addAll(bookingService.getAll());

        } catch (RuntimeException ex) {
            Common.showValidationError(ex.getMessage());
        }
    }


    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            cars.addAll(carService.getAll());
            tableViewCars.setItems(cars);
        });

        Platform.runLater(() -> {
            bookings.addAll(bookingService.getAll());
            tableViewBookings.setItems(bookings);
        });
    }

    public void RaportKm(ActionEvent actionEvent) {

    }

    public void RaportVenit(ActionEvent actionEvent) {

    }

    public void RaportCerere(ActionEvent actionEvent) {

    }




  //    public void AddElectric(ActionEvent actionEvent) {
//        try {
//            String id = electricId.getText();
//            String model = electricModel.getText();
//            double pret = Double.parseDouble(electricPret.getText());
//            double autonomie = Double.parseDouble(electricAutonomie.getText());
//            electricService.add(id,model,pret,autonomie);
//
//            electricId.clear();
//            electricModel.clear();
//            electricPret.clear();
//            electricAutonomie.clear();
//
//            electrics.clear();
//            electrics.addAll(electricService.getAll());
//
//        } catch (RuntimeException ex) {
//            Common.showValidationError(ex.getMessage());
//        }
//    }
//
//    public void SortElectric (ActionEvent actionEvent) {
//
//        electrics.clear();
//        List<ElectricCar> temp = electricService.sort();
//        electrics.addAll(temp);
//    }
//
//    public void SortDiesel (ActionEvent actionEvent) {
//
//        diesels.clear();
//        List<DieselCar> temp = dieselService.sort();
//        diesels.addAll(temp);
//    }
//
//    public void RefreshDiesel (ActionEvent actionEvent) {
//        diesels.clear();
//        diesels.addAll(dieselService.getAll());
//    }
//
//    public void RefreshElectric (ActionEvent actionEvent) {
//        electrics.clear();
//        electrics.addAll(electricService.getAll());
//    }
//
//    public void SearchDiesel (ActionEvent actionEvent) {
//        diesels.clear();
//        String model = searchModelDiesel.getText();
//        diesels.addAll(dieselService.cautareModel(model));
//    }
//
//    public void SearchElectric (ActionEvent actionEvent) {
//        electrics.clear();
//        String model = searchModelElectric.getText();
//        electrics.addAll(electricService.cautareModel(model));
//    }

}