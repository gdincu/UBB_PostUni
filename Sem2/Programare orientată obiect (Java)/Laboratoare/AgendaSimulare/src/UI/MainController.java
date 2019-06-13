package UI;
import Domain.Event;
import Service.EventService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class MainController {

    public TableView<Event> menu;
    public TableView<Event> tblEvent;
    public TableColumn colEventId;
    public TableColumn colEventName;
    public TableColumn colEventDate;
    public TableColumn colEventLength;
    public TableColumn colEventStartTime;
    public TextField txtEventId;
    public TextField txtEventName;
    public TextField txtEventDate;
    public TextField txtEventLength;
    public TextField txtEventStartTime;
    public Button btnAddEvent;
    public Button btnRemoveEvent;
    public Button btnSearchMaxEvent;
    public Button btnMaxEventClick;

    private EventService eventService;
    private ObservableList<Event> events = FXCollections.observableArrayList();

    public void setServices(EventService eventService) {
        this.eventService = eventService;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            events.addAll(eventService.getAll());
            tblEvent.setItems(events);
        });
    }

    /**
     * Sets the functionality of the Add button
     * @param actionEvent
     */
    public void btnAddAndUpdateEventClick(ActionEvent actionEvent) {
        try {

            String id = txtEventId.getText();
            String name = txtEventName.getText();
            String date = txtEventDate.getText();
            String length = txtEventLength.getText();
            String startTime = txtEventStartTime.getText();

            eventService.addEvent(id,name,date,length,startTime);

            events.clear();
            events.addAll(eventService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    /**
     * Sets the functionality of the Remove button
     * @param actionEvent
     */
    public void btnRemoveEventClick(ActionEvent actionEvent) {
        try {
            String id = txtEventId.getText();
            eventService.removeEvent(id);

            events.clear();
            events.addAll(eventService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    /**
     * Sets the functionality for a Get All button
     * @param actionEvent
     */
    public void btnGetAllEventClick(ActionEvent actionEvent) {
        try {
            events.clear();
            events.addAll(eventService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    /**
     * Sets the functionality for the Search Max Event button
     * @param actionEvent
     */
    public void setBtnSearchMaxEvent(ActionEvent actionEvent) {

        /* Sets the minimum event time */
        String min = "00:00";
        try {
            /* Will only look for the date*/
            String text = txtEventDate.getText();


            for (Event c : eventService.fullTextSearch(text))
                if(c.getLength().compareTo(min) > 0)
                    min = c.getLength();

                events.clear();
                events.add(eventService.fullTextSearch(min).get(0));
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }

    }
}