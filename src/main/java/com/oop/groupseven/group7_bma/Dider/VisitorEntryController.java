package com.oop.groupseven.group7_bma.Dider;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class VisitorEntryController {
    @FXML private TextField visitorNameField, purposeField, hoursField;
    @FXML private Label statusLabel;

    @FXML private void logEntry() {
        if (visitorNameField.getText().isEmpty() || purposeField.getText().isEmpty() || hoursField.getText().isEmpty()) {
            statusLabel.setText("Complete all fields.");
        } else {
            statusLabel.setText("Visitor registered.");
        }
    }
}