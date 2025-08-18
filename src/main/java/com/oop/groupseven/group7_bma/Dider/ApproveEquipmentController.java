package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * User 5 - Goal 4.
 */
public class ApproveEquipmentController {


    @FXML
    private TextField requestIdField;

    @FXML
    private TextField equipmentNameField;

    @FXML
    private Label statusLabel;

    @FXML
    public void approveRequest(ActionEvent event) {
        if (requestIdField.getText().isEmpty() || equipmentNameField.getText().isEmpty()) {
            statusLabel.setText("Fill in both fields.");
        } else {
            // TODO: Add DB approval logic
            statusLabel.setText("Request Approved ✔");
        }
    }

    @FXML
    public void rejectRequest(ActionEvent event) {
        if (requestIdField.getText().isEmpty() || equipmentNameField.getText().isEmpty()) {
            statusLabel.setText("Fill in both fields.");
        } else {
            // TODO: Add DB rejection logic
            statusLabel.setText("Request Rejected ✘");
        }
    }


}