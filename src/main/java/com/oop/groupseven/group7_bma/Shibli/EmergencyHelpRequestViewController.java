package com.oop.groupseven.group7_bma.Patient;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for Emergency Help Request view.
 * Allows patients to request urgent medical help.
 */
public class EmergencyHelpRequestViewController {

    @FXML
    private ComboBox<String> emergencyTypeCombo;

    @FXML
    private TextArea emergencyDetailsArea;

    @FXML
    public void initialize() {
        emergencyTypeCombo.setItems(FXCollections.observableArrayList(
                "Ambulance",
                "Doctor On Call",
                "Nurse Support",
                "Medical Equipment Delivery"
        ));
    }

    @FXML
    public void sendEmergencyRequest(ActionEvent event) {
        // TODO: Save emergency request to database and alert staff
        System.out.println("Emergency Type: " + emergencyTypeCombo.getValue());
        System.out.println("Details: " + emergencyDetailsArea.getText());
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
