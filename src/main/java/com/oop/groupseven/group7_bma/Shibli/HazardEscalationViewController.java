package com.oop.groupseven.group7_bma.MedicalInspector;

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
 * Controller for Hazard Escalation view.
 * Allows Medical Inspector to escalate critical issues to hospital admin.
 */
public class HazardEscalationViewController {

    @FXML
    private ComboBox<String> hazardTypeCombo;

    @FXML
    private TextArea hazardDescriptionArea;

    @FXML
    public void initialize() {
        // Example hazard types
        hazardTypeCombo.getItems().addAll(
                "Electrical Failure",
                "Gas Leak",
                "Oxygen Shortage",
                "Infection Outbreak"
        );
    }

    @FXML
    public void submitHazard(ActionEvent event) {
        // TODO: Save hazard to database and notify admin
        System.out.println("Hazard escalated: " + hazardTypeCombo.getValue());
        System.out.println("Details: " + hazardDescriptionArea.getText());
    }

    @FXML
    public void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(
                    "/com/oop/groupseven/group7_bma/MedicalInspector/MedicalInspectorDashboardView.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Inspector Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
