package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * Controller for staff attendance reports.
 * User 5 - Goal 5.
 */
public class AttendanceReportController {

    @FXML
    private TextField staffNameField;

    @FXML
    private DatePicker attendanceDatePicker;

    @FXML
    private ComboBox<String> statusCombo;

    @FXML
    private Label messageLabel;

    @FXML
    public void initialize() {
        statusCombo.getItems().addAll("Present", "Absent", "Late");
    }

    @FXML
    public void generateReport(ActionEvent event) {
        if (staffNameField.getText().isEmpty() ||
                attendanceDatePicker.getValue() == null ||
                statusCombo.getValue() == null) {
            messageLabel.setText("Fill in all fields.");
        } else {
            // TODO: Save to DB or generate file
            messageLabel.setText("Attendance recorded successfully.");
        }
    }

    @FXML
    public void clearForm(ActionEvent event) {
        staffNameField.clear();
        attendanceDatePicker.setValue(null);
        statusCombo.setValue(null);
        messageLabel.setText("");
    }


}