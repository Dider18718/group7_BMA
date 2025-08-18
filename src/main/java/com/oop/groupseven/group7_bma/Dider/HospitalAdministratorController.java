package com.oop.groupseven.group7_bma.Dider;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.scene.Node;

/**
 * Dashboard for Hospital Administrator.
 * Navigates to all goal screens.
 */
public class HospitalAdministratorController {

    @javafx.fxml.FXML
    private void openAddDoctor(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(), "Dider/AddDoctor.fxml");
    }

    @javafx.fxml.FXML
    private void openAssignShift(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(), "Dider/AssignShift.fxml");
    }

    @javafx.fxml.FXML
    private void openPatientRecords(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(), "Dider/PatientRecords.fxml");
    }

    @javafx.fxml.FXML
    private void openApproveEquipment(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(), "Dider/ApproveEquipment.fxml");
    }

    @javafx.fxml.FXML
    private void openAttendanceReport(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(), "Dider/AttendanceReport.fxml");
    }

    @javafx.fxml.FXML
    private void openHospitalInfo(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(), "Dider/HospitalInfo.fxml");
    }

    @javafx.fxml.FXML
    private void openEmergencyAlert(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(), "Dider/EmergencyAlert.fxml");
    }

    @javafx.fxml.FXML
    private void openBedStatus(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(), "Dider/BedStatus.fxml");
    }

    @javafx.fxml.FXML
    private void handleLogout(ActionEvent event) {
        // adjust path if Login.fxml lives elsewhere
        HelloApplication.switchScene((Node) event.getSource(), "Login.fxml");
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        HelloApplication.switchScene((Node) actionEvent.getSource(), "AppLauncher.fxml");
    }
}
