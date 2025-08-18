package com.oop.groupseven.group7_bma.Shibli;

import com.oop.groupseven.group7_bma.HelloApplication;
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

    @Deprecated
    public void goToBookAppointment(ActionEvent event) {
        switchScene(event, "BookAppointmentView.fxml", "Book Appointment");
    }

    @Deprecated
    public void goToPayments(ActionEvent event) {
        switchScene(event, "MedicalPaymentView.fxml", "Payments");
    }

    @Deprecated
    public void goToEmergencyHelp(ActionEvent event) {
        switchScene(event, "EmergencyHelpRequestView.fxml", "Emergency Help");
    }

    @Deprecated
    public void goToFeedback(ActionEvent event) {
        switchScene(event, "FeedbackSubmissionView.fxml", "Feedback");
    }

    @Deprecated
    public void goToAppointments(ActionEvent event) {
        switchScene(event, "ManageAppointmentsView.fxml", "Manage Appointments");
    }

    @Deprecated
    public void goToLocations(ActionEvent event) {
        switchScene(event, "ManageLocationsView.fxml", "Saved Locations");
    }

    @Deprecated
    public void goToPrescriptionHistory(ActionEvent event) {
        switchScene(event, "PrescriptionHistoryView.fxml", "Prescription History");
    }

    @Deprecated
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

    @FXML
    public void handleManageAppointments(ActionEvent actionEvent) {
    }

    @FXML
    public void handleEmergency(ActionEvent actionEvent) {
    }

    @FXML
    public void handleManageLocations(ActionEvent actionEvent) {
    }

    @FXML
    public void handlePayment(ActionEvent actionEvent) {
    }

    @FXML
    public void handleBookAppointment(ActionEvent actionEvent) {
    }

    @FXML
    public void handleFeedback(ActionEvent actionEvent) {
    }

    @FXML
    public void handleLogout(ActionEvent actionEvent) {
    }

    @FXML
    public void handlePrescriptionHistory(ActionEvent actionEvent) {
    }

    @FXML
    public void handleFavoriteDoctors(ActionEvent actionEvent) {
    }

    @FXML
    public void backButton(ActionEvent actionEvent) {
        HelloApplication.switchScene((Node) actionEvent.getSource(), "AppLauncher.fxml");
    }
}
