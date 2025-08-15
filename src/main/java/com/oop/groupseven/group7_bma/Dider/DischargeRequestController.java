package com.oop.groupseven.group7_bma.Dider;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class DischargeRequestController {
    @FXML private TextField patientIdField, dateField;
    @FXML private TextArea summaryArea;
    @FXML private Label statusLabel;

    @FXML private void submit() {
        if (patientIdField.getText().isEmpty() || dateField.getText().isEmpty() || summaryArea.getText().isEmpty()) {
            statusLabel.setText("Fill patient, date, and summary.");
        } else {
            statusLabel.setText("Discharge request forwarded to admin.");
        }
    }
}