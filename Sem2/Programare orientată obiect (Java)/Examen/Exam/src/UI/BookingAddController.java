package UI;

import Service.BookingService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BookingAddController {
    public TextField txtBookingId;
    public TextField txtCarId;
    public TextField txtDays;
    public TextField txtKm;
    public Button btnAdd;
    public Button btnCancel;


    private BookingService bookingService;

    public void setService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void btnAddClick(ActionEvent actionEvent) {

        try {
            String bookingId = String.valueOf(txtBookingId.getText());
            String carId = String.valueOf(txtCarId.getText());
            int Km = Integer.parseInt(txtKm.getText());
            int Days = Integer.parseInt(txtDays.getText());

            bookingService.addOrUpdate(bookingId, carId, Km, Days);

            btnCancelClick(actionEvent);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }
}
