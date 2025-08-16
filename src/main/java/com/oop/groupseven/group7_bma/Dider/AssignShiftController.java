package com.oop.groupseven.group7_bma.Dider;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AssignShiftController {

    @FXML
    private TextField doctorNameField, dateField, timeField;
    @FXML
    private Label statusLabel;

    @FXML
    private void assignShift() {
        if (doctorNameField.getText().isEmpty() || dateField.getText().isEmpty() || timeField.getText().isEmpty()) {
            statusLabel.setText("Fill in all fields!");
        } else {

            statusLabel.setText("Shift assigned successfully.");
        }
    }
}