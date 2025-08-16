package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import com.oop.groupseven.group7_bma.utils.SceneSwitcher;

/**
 * Dashboard for Hospital Administrator.
 * Provides navigation to all 8 goal screens.
 */
public class HospitalAdministratorController {

    @FXML
    private void openAddDoctor(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "AddDoctor.fxml", "Add Doctor Profile");
    }

    @FXML
    private void openAssignShift(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "AssignShift.fxml", "Assign Shift to Doctor");
    }

    @FXML
    private void openPatientRecords(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "PatientRecords.fxml", "View Patient Records");
    }

    @FXML
    private void openApproveEquipment(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "ApproveEquipment.fxml", "Approve Equipment Requests");
    }

    @FXML
    private void openAttendanceReport(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "AttendanceReport.fxml", "Generate Attendance Report");
    }

    @FXML
    private void openHospitalInfo(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "HospitalInfo.fxml", "Update Hospital Information");
    }

    @FXML
    private void openEmergencyAlert(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "EmergencyAlert.fxml", "Create Emergency Alert");
    }

    @FXML
    private void openBedStatus(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "BedStatus.fxml", "Monitor Bed Availability");
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "Login.fxml", "Login");
    }
}