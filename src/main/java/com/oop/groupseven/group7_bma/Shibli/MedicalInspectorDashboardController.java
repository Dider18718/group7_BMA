package com.oop.groupseven.group7_bma.Shibli;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class MedicalInspectorDashboardController {

    @javafx.fxml.FXML
    private void handleLogInspection(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(),
                "Shibli/log_inspection.fxml");
    }

    @javafx.fxml.FXML
    private void handleReportDamage(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(),
                "Shibli/report_damage.fxml");
    }

    @javafx.fxml.FXML
    private void handleCleaningStatus(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(),
                "Shibli/cleaning_status.fxml");
    }

    @javafx.fxml.FXML
    private void handleRoomStatus(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(),
                "Shibli/room_status.fxml");
    }

    @javafx.fxml.FXML
    private void handleViewHistory(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(),
                "Shibli/inspection_history.fxml");
    }

    @javafx.fxml.FXML
    private void handleFuelCheck(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(),
                "Shibli/fuel_check.fxml");
    }

    @javafx.fxml.FXML
    private void handleHazardEscalation(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(),
                "Shibli/hazard_escalation.fxml");
    }

    @javafx.fxml.FXML
    private void handleGenerateReport(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(),
                "Shibli/generate_reports.fxml");
    }

    @Deprecated
    private void backButton(ActionEvent event) {
        HelloApplication.switchScene((Node) event.getSource(), "AppLauncher.fxml");
    }
}
