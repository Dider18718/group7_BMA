package com.oop.groupseven.group7_bma.Dider;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ApproveEquipmentController {
    @FXML private TextField requestIdField, equipmentField;
    @FXML private Label statusLabel;

    @FXML private void approve() {
        if (requestIdField.getText().isEmpty() || equipmentField.getText().isEmpty()) {
            statusLabel.setText("Fill Request ID and Equipment.");
        } else {
            statusLabel.setText("Approved request #" + requestIdField.getText());
        }
    }
}