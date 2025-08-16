package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.oop.groupseven.group7_bma.utils.SceneSwitcher;

public class VisitorEntryController {

    @FXML private TextField visitorNameField, patientNameField, entryTimeField;
    @FXML private Label statusLabel;

    @FXML
    public void allowEntry(ActionEvent event) {
        if (visitorNameField.getText().isEmpty() || patientNameField.getText().isEmpty() || entryTimeField.getText().isEmpty()) {
            statusLabel.setText("Please fill all fields.");
        } else {
            // TODO: Save to DB
            statusLabel.setText("Visitor entry recorded.");
        }
    }

    @FXML
    public void clearForm(ActionEvent event) {
        visitorNameField.clear();
        patientNameField.clear();
        entryTimeField.clear();
        statusLabel.setText("");
    }

    @FXML
    public void handleBack(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "PatientSupport.fxml", "Patient Support Dashboard");
    }
}