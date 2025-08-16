package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import com.oop.groupseven.group7_bma.utils.SceneSwitcher;

public class PatientSupportController {

    @FXML
    public void goRegisterPatient(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "RegisterPatient.fxml", "Register New Patient");
    }

    @FXML
    public void goBookAppointment(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "BookPatientPSR.fxml", "Book Appointment for Patient");
    }

    @FXML
    public void goUpdateContactInfo(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "EditContactInfo.fxml", "Update Patient Contact Info");
    }

    @FXML
    public void goUpdateAppointment(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "EditAppointmentPSR.fxml", "Update Appointment Details");
    }

    @FXML
    public void goDischargeRequest(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "DischargeRequest.fxml", "Process Discharge Request");
    }

    @FXML
    public void goVisitorEntry(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "VisitorEntry.fxml", "Manage Visitor Entry");
    }

    @FXML
    public void goBillingDetails(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "BillingDetails.fxml", "View Billing Details");
    }

    @FXML
    public void goSupportTickets(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "SupportTickets.fxml", "Respond to Patient Queries");
    }

    @FXML
    public void handleLogout(ActionEvent event) {

        SceneSwitcher.switchScene((Node) event.getSource(),
                "Login.fxml", "Login");
    }
}