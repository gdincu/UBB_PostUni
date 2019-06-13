package UI;

import javafx.scene.control.Alert;

public class Common {
    /**
     * Used for the validation errors in the FX console
     * @param message
     */
    public static void showValidationError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText("Validation error:");
        alert.setContentText(message);
        alert.showAndWait();
    }
}