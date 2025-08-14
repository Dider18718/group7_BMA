package com.oop.groupseven.group7_bma.Patient;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for Manage Appointments view.
 * Allows patients to view, edit, and cancel booked appointments.
 */
public class ManageAppointmentsViewController {

    @FXML
    private ListView<String> appointmentsList;

    @FXML
    public void initialize() {
        // Example data - replace with database values
        appointmentsList.setItems(FXCollections.observableArrayList(
                "12 Aug 2025 - Dr. Rahman - Cardiology",
                "15 Aug 2025 - Dr. Ahmed - Neurology"
        ));
    }

    @FXML
    public void editAppointment(ActionEvent event) {
        // TODO: Implement editing logic
        String selected = appointmentsList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            System.out.println("Editing appointment: " + selected);
        }
    }

    @FXML
    public void cancelAppointment(ActionEvent event) {
        // TODO: Remove from database
        String selected = appointmentsList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            System.out.println("Canceled appointment: " + selected);
            appointmentsList.getItems().remove(selected);
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
