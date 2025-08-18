package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * Simplified controller for managing patient records.
 * User 5 - Goal 3.
 */
public class PatientRecordsController {

    @FXML
    private TextField patientNameField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField conditionField;

    @FXML
    private TextField lastVisitField;

    @FXML
    private Label statusLabel;

    @FXML
    public void saveRecord(ActionEvent event) {
        if (patientNameField.getText().isEmpty() ||
                ageField.getText().isEmpty() ||
                conditionField.getText().isEmpty() ||
                lastVisitField.getText().isEmpty()) {
            statusLabel.setText("Please complete all fields.");
        } else {
            // TODO: Save to database
            statusLabel.setText("Patient record saved.");
        }
    }

    @FXML
    public void clearForm(ActionEvent event) {

        patientNameField.clear();
        ageField.clear();
        conditionField.clear();
        lastVisitField.clear();
        statusLabel.setText("");
    }


}