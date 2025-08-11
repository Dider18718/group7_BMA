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
 * Controller for the Daily Inspection form.
 * Records daily equipment and room checks.
 */
public class DailyInspectionFormViewController {

    @FXML
    private TextField oxygenLevelField;

    @FXML
    private TextField ventilatorCountField;

    @FXML
    private TextArea notesArea;

    @FXML
    public void saveInspection(ActionEvent event) {
        // TODO: Save to database or file
        System.out.println("Inspection saved: "
                + oxygenLevelField.getText() + " oxygen, "
                + ventilatorCountField.getText() + " ventilators.");
    }

    @FXML
    public void clearForm(ActionEvent event) {
        oxygenLevelField.clear();
        ventilatorCountField.clear();
        notesArea.clear();
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
