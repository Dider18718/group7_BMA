package com.oop.groupseven.group7_bma.Dider;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class PatientSupportController {

    @javafx.fxml.FXML
    private void goRegisterPatient(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(),
                "Dider/RegisterPatient.fxml");
    }

    @javafx.fxml.FXML
    private void goBookAppointment(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(),
                "Dider/BookPatientPSR.fxml");
    }

    @javafx.fxml.FXML
    private void goUpdateContactInfo(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(),
                "Dider/EditContactInfo.fxml");
    }

    @javafx.fxml.FXML
    private void goUpdateAppointment(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(),
                "Dider/EditAppointmentPSR.fxml");
    }

    @javafx.fxml.FXML
    private void goDischargeRequest(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(),
                "Dider/DischargeRequest.fxml");
    }

    @javafx.fxml.FXML
    private void goVisitorEntry(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(),
                "Dider/VisitorEntry.fxml");
    }

    @javafx.fxml.FXML
    private void goBillingDetails(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(),
                "Dider/BillingDetails.fxml");
    }

    @javafx.fxml.FXML
    private void goSupportTickets(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(),
                "Dider/SupportTickets.fxml");
    }

    @javafx.fxml.FXML
    private void handleLogout(ActionEvent event) {
        // Adjust path if your Login.fxml is in a subfolder
        HelloApplication.switchScene((Node) event.getSource(),
                "Login.fxml");
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        HelloApplication.switchScene((Node) actionEvent.getSource(), "AppLauncher.fxml");
    }
}
