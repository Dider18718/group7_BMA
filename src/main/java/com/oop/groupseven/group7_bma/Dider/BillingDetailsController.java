package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BillingDetailsController {

    @FXML private TextField patientNameField;
    @FXML private Label billingInfoLabel;

    @FXML
    public void viewBilling(ActionEvent event) {
        if (patientNameField.getText().isEmpty()) {
            billingInfoLabel.setText("Enter patient name.");
        } else {

            // TODO: Fetch from DB
            billingInfoLabel.setText("Billing Details: Room - $500, Medications - $150");
        }
    }


}