package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.oop.groupseven.group7_bma.utils.SceneSwitcher;

public class RegisterPatientController {

    @FXML private TextField nameField, ageField, contactField;
    @FXML private ComboBox<String> genderCombo;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
        genderCombo.getItems().addAll("Male", "Female", "Other");
    }

    @FXML
    public void registerPatient(ActionEvent event) {
        if (nameField.getText().isEmpty() || ageField.getText().isEmpty() ||
                genderCombo.getValue() == null || contactField.getText().isEmpty()) {
            statusLabel.setText("All fields are required.");
        } else {
            // TODO: Save to database
            statusLabel.setText("Patient registered successfully.");
        }
    }

    @FXML
    public void clearForm(ActionEvent event) {
        nameField.clear();
        ageField.clear();
        contactField.clear();
        genderCombo.setValue(null);
        statusLabel.setText("");
    }

    @FXML
    public void handleBack(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "PatientSupport.fxml", "Patient Support Dashboard");
    }
}