package com.oop.groupseven.group7_bma.MedicalInspector;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class RoomAvailabilityViewController {

    @FXML
    private RadioButton availableRadio;
    @FXML
    private RadioButton unavailableRadio;
    @FXML
    private ComboBox<String> roomCombo;
    @FXML
    private TextField reasonField;

    private ToggleGroup availabilityGroup;

    @FXML
    public void initialize() {
        // Initialize ToggleGroup
        availabilityGroup = new ToggleGroup();
        availableRadio.setToggleGroup(availabilityGroup);
        unavailableRadio.setToggleGroup(availabilityGroup);
        availableRadio.setSelected(true);

        // Fill room combo
        roomCombo.setItems(FXCollections.observableArrayList("Room-101", "Room-102", "Room-103"));
    }

    @FXML
    public void handleSubmit(ActionEvent event) {
        String selectedRoom = roomCombo.getValue();
        RadioButton selectedStatus = (RadioButton) availabilityGroup.getSelectedToggle();
        String reason = reasonField.getText();

        if (selectedRoom == null) {
            showAlert("Please select a room.");
            return;
        }

        String status = (selectedStatus != null) ? selectedStatus.getText() : "Unknown";

        System.out.println("Room: " + selectedRoom);
        System.out.println("Status: " + status);
        if (status.equals("Unavailable")) {
            System.out.println("Reason: " + reason);
        }

        // TODO: Save the updated availability
        showAlert("Room availability updated successfully!");
    }

    @FXML
    public void handleBack(ActionEvent event) {
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

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
