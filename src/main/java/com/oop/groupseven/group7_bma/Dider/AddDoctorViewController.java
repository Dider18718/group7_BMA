package com.oop.groupseven.group7_bma.Dider;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddDoctorViewController {

    @FXML
    private TextField nameField, departmentField;
    @FXML
    private Button submitButton;
    @FXML
    private Label messageLabel;

    @FXML
    private void handleSubmit() {
        String name = nameField.getText();
        String dept = departmentField.getText();

        if (name.isEmpty() || dept.isEmpty()) {
            messageLabel.setText("Please fill all fields.");
        } else {
            messageLabel.setText("Doctor Added Successfully!");
        }
    }
}
