package com.oop.groupseven.group7_bma.MedicalInspector;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for Room Availability view.
 * Allows Medical Inspector to set a room's availability status.
 */
public class RoomAvailabilityViewController {

    @FXML
    private TableView<?> roomTable;

    @FXML
    private TableColumn<?, ?> roomIdCol;

    @FXML
    private TableColumn<?, ?> availabilityCol;

    @FXML
    private ComboBox<String> availabilityCombo;

    @FXML
    public void initialize() {
        // Fill combo with room status options
        availabilityCombo.setItems(FXCollections.observableArrayList("Available", "Unavailable"));
    }

    @FXML
    public void handleUpdateAvailability(ActionEvent event) {
        // TODO: Update the selected room's availability in the database
        System.out.println("Availability updated to: " + availabilityCombo.getValue());
    }

    @FXML
    public void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(
                    "/com/oop/groupseven/group7_bma/MedicalInspector/MedicalInspectorDashboardView.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Inspector Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
