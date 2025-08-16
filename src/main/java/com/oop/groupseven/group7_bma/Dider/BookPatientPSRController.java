package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import com.oop.groupseven.group7_bma.utils.SceneSwitcher;

public class BookPatientPSRController {

    @FXML private TextField patientNameField, doctorField;
    @FXML private DatePicker datePicker;
    @FXML private ComboBox<String> timeCombo;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
        timeCombo.getItems().addAll("Morning", "Afternoon", "Evening");
    }

    @FXML
    public void bookAppointment(ActionEvent event) {
        if (patientNameField.getText().isEmpty() || doctorField.getText().isEmpty() ||
                datePicker.getValue() == null || timeCombo.getValue() == null) {
            statusLabel.setText("Fill all fields.");
        } else {
            // TODO: Save to DB
            statusLabel.setText("Appointment booked successfully.");
        }
    }

    @FXML
    public void clearForm(ActionEvent event) {
        patientNameField.clear();
        doctorField.clear();
        datePicker.setValue(null);
        timeCombo.setValue(null);
        statusLabel.setText("");
    }

    @FXML
    public void handleBack(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "PatientSupport.fxml", "Patient Support Dashboard");
    }
}