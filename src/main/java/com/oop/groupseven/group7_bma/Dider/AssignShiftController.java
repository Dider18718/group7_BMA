package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * Controller for assigning shifts to doctors.
 * CRA: User-5 Goal-2 workflow.
 */
public class AssignShiftController {

    @FXML
    private TextField doctorNameField;

    @FXML
    private ComboBox<String> shiftTypeCombo;

    @FXML
    private DatePicker shiftDatePicker;

    @FXML
    private Label statusLabel;

    /**
     * Initializes the combo box with shift types.
     */
    @FXML
    public void initialize() {
        shiftTypeCombo.getItems().addAll("Morning", "Afternoon", "Night");
    }

    /**
     * Assigns a shift to a doctor.
     * TODO: Save to database.
     */
    @FXML
    public void handleAssign(ActionEvent event) {
        if (doctorNameField.getText().isEmpty() ||
                shiftTypeCombo.getValue() == null ||
                shiftDatePicker.getValue() == null) {
            statusLabel.setText("Please fill all fields.");
        } else {
            // TODO: Database save logic
            statusLabel.setText("Shift assigned successfully!");
        }
    }

    /**
     * Clears the form.
     */
    @FXML
    public void clearForm(ActionEvent event) {
        doctorNameField.clear();
        shiftTypeCombo.setValue(null);
        shiftDatePicker.setValue(null);
        statusLabel.setText("");
    }


}
