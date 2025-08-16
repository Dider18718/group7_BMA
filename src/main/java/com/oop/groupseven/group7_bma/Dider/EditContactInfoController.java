package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.oop.groupseven.group7_bma.utils.SceneSwitcher;

public class EditContactInfoController {

    @FXML private TextField patientNameField, contactField;
    @FXML private Label statusLabel;

    @FXML
    public void updateContact(ActionEvent event) {
        if (patientNameField.getText().isEmpty() || contactField.getText().isEmpty()) {
            statusLabel.setText("All fields are required.");
        } else {
            // TODO: Update DB
            statusLabel.setText("Contact info updated.");
        }
    }

    @FXML
    public void clearForm(ActionEvent event) {
        patientNameField.clear();

        contactField.clear();
        statusLabel.setText("");
    }

    @FXML
    public void handleBack(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "PatientSupport.fxml", "Patient Support Dashboard");
    }
}