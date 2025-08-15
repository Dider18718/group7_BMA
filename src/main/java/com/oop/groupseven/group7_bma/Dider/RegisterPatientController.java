package com.oop.groupseven.group7_bma.Dider;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegisterPatientController {

    @FXML
    private TextField nameField, ageField, contactField;
    @FXML
    private Label statusLabel;

    @FXML
    private void registerPatient() {
        if (nameField.getText().isEmpty() || ageField.getText().isEmpty() || contactField.getText().isEmpty()) {
            statusLabel.setText("All fields are required.");
        } else {
            // Mock DB save
            statusLabel.setText("Patient Registered Successfully!");
        }
    }
}