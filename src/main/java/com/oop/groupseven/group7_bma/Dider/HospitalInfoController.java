package com.oop.groupseven.group7_bma.Dider;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HospitalInfoController {
    @FXML private TextField contactField, addressField, servicesField;
    @FXML private Label statusLabel;

    @FXML private void save() {
        if (contactField.getText().isEmpty() || addressField.getText().isEmpty()) {
            statusLabel.setText("Contact and Address are required.");
        } else {
            statusLabel.setText("Hospital info updated successfully.");
        }
    }
}