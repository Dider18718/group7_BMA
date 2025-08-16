package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.oop.groupseven.group7_bma.utils.SceneSwitcher;

public class DischargeRequestController {

    @FXML private TextField patientNameField;
    @FXML private TextArea reasonArea;
    @FXML private Label statusLabel;

    @FXML
    public void processDischarge(ActionEvent event) {
        if (patientNameField.getText().isEmpty() || reasonArea.getText().isEmpty()) {
            statusLabel.setText("All fields must be filled.");
        } else {
            // TODO: Save to DB
            statusLabel.setText("Discharge request processed.");
        }
    }

    @FXML
    public void clearForm(ActionEvent event) {
        patientNameField.clear();

        reasonArea.clear();
        statusLabel.setText("");
    }

    @FXML
    public void handleBack(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "PatientSupport.fxml", "Patient Support Dashboard");
    }
}