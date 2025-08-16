package com.oop.groupseven.group7_bma.Dider;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EmergencyAlertController {
    @FXML private TextField titleField;
    @FXML private ComboBox<String> priorityBox;
    @FXML private TextArea messageArea;
    @FXML private Label statusLabel;

    @FXML private void initialize() {
        priorityBox.getItems().addAll("Low","Medium","High","Critical");
        priorityBox.getSelectionModel().select("High");
    }
    @FXML private void send() {
        if (titleField.getText().isEmpty() || messageArea.getText().isEmpty()) {
            statusLabel.setText("Fill title and message.");
        } else {
            statusLabel.setText("Alert dispatched (" + priorityBox.getValue() + ").");
        }
    }
}