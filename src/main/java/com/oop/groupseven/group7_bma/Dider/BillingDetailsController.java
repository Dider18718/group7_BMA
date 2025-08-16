package com.oop.groupseven.group7_bma.Dider;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BillingDetailsController {
    @FXML private TextField patientIdField;
    @FXML private TextArea billArea;

    @FXML private void load() {
        if (patientIdField.getText().isEmpty()) {
            billArea.setText("Enter a Patient ID.");
        } else {
            billArea.setText(
                    "Patient ID: " + patientIdField.getText() +
                            "\nInvoice #B-10231\nRoom: 5,000\nMedicine: 3,200\nLab: 1,200\nTotal: 9,400 BDT\nStatus: Unpaid");
        }
    }
}