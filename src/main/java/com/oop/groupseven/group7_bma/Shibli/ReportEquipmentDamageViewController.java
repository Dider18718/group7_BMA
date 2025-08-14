package com.oop.groupseven.group7_bma.MedicalInspector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for reporting damaged equipment.
 * Used by Medical Inspector to record issues with hospital gear.
 */
public class ReportEquipmentDamageViewController {

    @FXML
    private TextField equipmentNameField;

    @FXML
    private TextArea damageDescriptionArea;

    @FXML
    public void submitDamageReport(ActionEvent event) {
        // TODO: Save this damage report to the database
        System.out.println("Reported damage: " + equipmentNameField.getText());
        System.out.println("Description: " + damageDescriptionArea.getText());
    }

    @FXML
    public void clearForm(ActionEvent event) {
        equipmentNameField.clear();
        damageDescriptionArea.clear();
    }

    @FXML
    public void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/oop/groupseven/group7_bma/MedicalInspector/MedicalInspectorDashboardView.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Inspector Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
