package com.oop.groupseven.group7_bma.Patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for Patient Dashboard.
 * Main navigation hub for patient actions.
 */
public class PatientDashboardViewController {

    @FXML
    public void goToBookAppointment(ActionEvent event) {
        switchScene(event, "BookAppointmentView.fxml", "Book Appointment");
    }

    @FXML
    public void goToPayments(ActionEvent event) {
        switchScene(event, "MedicalPaymentView.fxml", "Payments");
    }

    @FXML
    public void goToEmergencyHelp(ActionEvent event) {
        switchScene(event, "EmergencyHelpRequestView.fxml", "Emergency Help");
    }

    @FXML
    public void goToFeedback(ActionEvent event) {
        switchScene(event, "FeedbackSubmissionView.fxml", "Feedback");
    }

    @FXML
    public void goToAppointments(ActionEvent event) {
        switchScene(event, "ManageAppointmentsView.fxml", "Manage Appointments");
    }

    @FXML
    public void goToLocations(ActionEvent event) {
        switchScene(event, "ManageLocationsView.fxml", "Saved Locations");
    }

    @FXML
    public void goToPrescriptionHistory(ActionEvent event) {
        switchScene(event, "PrescriptionHistoryView.fxml", "Prescription History");
    }

    @FXML
    public void goToFavoriteDoctors(ActionEvent event) {
        switchScene(event, "FavoriteDoctorsView.fxml", "Favorite Doctors");
    }

    private void switchScene(ActionEvent event, String fxmlFile, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/oop/groupseven/group7_bma/Patient/" + fxmlFile));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
