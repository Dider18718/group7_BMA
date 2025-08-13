package com.oop.groupseven.group7_bma.Patient;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for Manage Locations view.
 * Allows patients to save and update pickup/drop-off addresses.
 */
public class ManageLocationsViewController {

    @FXML
    private ListView<String> locationList;

    @FXML
    private TextField locationInputField;

    @FXML
    public void initialize() {
        // Example saved locations
        locationList.setItems(FXCollections.observableArrayList(
                "Home - 123 Green Road, Dhaka",
                "Office - 45 Motijheel, Dhaka"
        ));
    }

    @FXML
    public void addLocation(ActionEvent event) {
        String newLocation = locationInputField.getText();
        if (!newLocation.isEmpty()) {
            locationList.getItems().add(newLocation);
            locationInputField.clear();
        }
    }

    @FXML
    public void removeLocation(ActionEvent event) {
        String selected = locationList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            locationList.getItems().remove(selected);
        }
    }

    @FXML
    public void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(
                    "/com/oop/groupseven/group7_bma/Patient/PatientDashboardView.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Patient Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
