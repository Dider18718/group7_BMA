package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.oop.groupseven.group7_bma.utils.SceneSwitcher;

public class BedStatusController {

    @FXML
    private TextField wardField;

    @FXML
    private TextField availableBedsField;

    @FXML
    private Label statusLabel;

    @FXML
    public void updateBedStatus(ActionEvent event) {
        if (wardField.getText().isEmpty() || availableBedsField.getText().isEmpty()) {
            statusLabel.setText("Please fill all fields.");
        } else {
            // TODO: Update bed count in DB
            statusLabel.setText("Bed availability updated.");
        }
    }

    @FXML
    public void clearForm(ActionEvent event) {
        wardField.clear();
        availableBedsField.clear();
        statusLabel.setText("");
    }

    @FXML
    public void handleBack(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "HospitalAdministrator.fxml", "Hospital Administrator Dashboard");
    }
}