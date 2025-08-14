package com.oop.groupseven.group7_bma.Dider;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EditContactInfoController {
    @FXML private TextField patientIdField, phoneField, addressField;
    @FXML private Label statusLabel;

    @FXML private void save() {
        if (patientIdField.getText().isEmpty() || phoneField.getText().isEmpty() || addressField.getText().isEmpty()) {
            statusLabel.setText("All fields required.");
        } else {
            statusLabel.setText("Contact info updated.");
        }
    }
}