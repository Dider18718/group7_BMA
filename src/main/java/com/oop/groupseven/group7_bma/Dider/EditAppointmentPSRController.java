package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;

public class EditAppointmentPSRController {

    @FXML private TextField patientNameField;
    @FXML private DatePicker datePicker;
    @FXML private ComboBox<String> timeCombo;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
        timeCombo.getItems().addAll("Morning", "Afternoon", "Evening");
    }

    @FXML
    public void updateAppointment(ActionEvent event) {
        if (patientNameField.getText().isEmpty() || datePicker.getValue() == null || timeCombo.getValue() == null) {
            statusLabel.setText("Fill all fields.");
        } else {
            // TODO: Update in DB
            statusLabel.setText("Appointment updated successfully.");
        }
    }

    @FXML
    public void clearForm(ActionEvent event) {

        patientNameField.clear();
        datePicker.setValue(null);
        timeCombo.setValue(null);
        statusLabel.setText("");
    }


}