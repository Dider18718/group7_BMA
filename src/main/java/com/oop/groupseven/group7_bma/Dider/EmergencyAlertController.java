package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.oop.groupseven.group7_bma.utils.SceneSwitcher;

public class EmergencyAlertController {

    @FXML
    private TextField alertTitleField;

    @FXML
    private TextArea alertMessageArea;

    @FXML
    private Label statusLabel;

    @FXML
    public void sendAlert(ActionEvent event) {
        if (alertTitleField.getText().isEmpty() || alertMessageArea.getText().isEmpty()) {
            statusLabel.setText("Title and message are required.");
        } else {
            // TODO: Send alert to system
            statusLabel.setText("Emergency alert sent!");
        }
    }

    @FXML
    public void clearForm(ActionEvent event) {

        alertTitleField.clear();
        alertMessageArea.clear();
        statusLabel.setText("");
    }

    @FXML
    public void handleBack(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "HospitalAdministrator.fxml", "Hospital Administrator Dashboard");
    }
}