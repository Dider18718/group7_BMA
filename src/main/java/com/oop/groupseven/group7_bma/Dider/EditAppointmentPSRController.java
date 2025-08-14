package com.oop.groupseven.group7_bma.Dider;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EditAppointmentPSRController {
    @FXML private TextField appointmentIdField, newDateField, newTimeField;
    @FXML private Label statusLabel;

    @FXML private void update() {
        if (appointmentIdField.getText().isEmpty() || newDateField.getText().isEmpty() || newTimeField.getText().isEmpty()) {
            statusLabel.setText("Enter ID, date, and time.");
        } else {
            statusLabel.setText("Appointment updated successfully.");
        }
    }
}