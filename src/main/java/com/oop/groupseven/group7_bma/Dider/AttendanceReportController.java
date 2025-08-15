package com.oop.groupseven.group7_bma.Dider;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AttendanceReportController {
    @FXML private TextField departmentField, monthField;
    @FXML private TextArea reportArea;

    @FXML private void generate() {
        if (departmentField.getText().isEmpty() || monthField.getText().isEmpty()) {
            reportArea.setText("Select Department and Month.");
            return;
        }
        reportArea.setText("Dept: " + departmentField.getText() + "\nMonth: " + monthField.getText()
                + "\nPresent: 92%\nAbsent: 8%\nRemarks: Stable attendance.");
    }
}