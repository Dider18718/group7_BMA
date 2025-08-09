package com.oop.groupseven.group7_bma.Shibli;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

public class MedicalInspectorDashboardViewController {

    @FXML
    private void handleLogInspection(ActionEvent event) throws IOException {
        changeScene(event, "log_inspection.fxml");
    }

    @FXML
    private void handleReportDamage(ActionEvent event) throws IOException {
        changeScene(event, "report_damage.fxml");
    }

    @FXML
    private void handleCleaningStatus(ActionEvent event) throws IOException {
        changeScene(event, "cleaning_status.fxml");
    }

    @FXML
    private void handleRoomStatus(ActionEvent event) throws IOException {
        changeScene(event, "room_status.fxml");
    }

    @FXML
    private void handleViewHistory(ActionEvent event) throws IOException {
        changeScene(event, "inspection_history.fxml");
    }

    @FXML
    private void handleFuelCheck(ActionEvent event) throws IOException {
        changeScene(event, "fuel_check.fxml");
    }

    @FXML
    private void handleHazardEscalation(ActionEvent event) throws IOException {
        changeScene(event, "hazard_escalation.fxml");
    }

    @FXML
    private void handleGenerateReport(ActionEvent event) throws IOException {
        changeScene(event, "generate_reports.fxml");
    }

    private void changeScene(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}

