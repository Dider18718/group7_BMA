package com.oop.groupseven.group7_bma.Dider;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BookPatientPSRController {

    @FXML
    private TextField patientNameField, doctorField, dateField;
    @FXML
    private Label statusLabel;

    @FXML
    private void bookAppointment() {
        if (patientNameField.getText().isEmpty() || doctorField.getText().isEmpty() || dateField.getText().isEmpty()) {
            statusLabel.setText("Please complete all fields.");
        } else {
            // Mock appointment booking
            statusLabel.setText("Appointment Booked!");
        }
    }
}