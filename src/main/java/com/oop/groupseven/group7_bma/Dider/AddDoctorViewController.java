package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.oop.groupseven.group7_bma.utils.SceneSwitcher;

/**
 * Controller for Add Doctor Profile form.
 * Used by Hospital Administrator to add new doctors to the system.
 * Matches CRA: User-5 Goal-1 workflow.
 */
public class AddDoctorViewController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField departmentField;

    @FXML
    private TextField certificationField;

    @FXML
    private TextField idProofField;

    @FXML
    private Label statusLabel;

    /**
     * Handles the form submission for adding a new doctor.
     * TODO: Add logic to save doctor details into the database.
     */
    @FXML
    public void handleSubmit(ActionEvent event) {
        if (nameField.getText().isEmpty() || departmentField.getText().isEmpty()
                || certificationField.getText().isEmpty() || idProofField.getText().isEmpty()) {
            statusLabel.setText("Please fill all fields.");
        } else {
            // TODO: Database save logic
            statusLabel.setText("Doctor Added Successfully!");
        }
    }

    /**
     * Clears the form fields.
     */
    @FXML
    public void clearForm(ActionEvent event) {
        nameField.clear();
        departmentField.clear();
        certificationField.clear();
        idProofField.clear();
        statusLabel.setText("");
    }

    /**
     * Navigates back to the Hospital Administrator Dashboard.
     */
    @FXML
    public void handleBack(ActionEvent event) {
        SceneSwitcher.switchScene((Node) event.getSource(),
                "HospitalAdministrator.fxml", "Hospital Administrator Dashboard");
    }
}
