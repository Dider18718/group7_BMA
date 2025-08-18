package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class HospitalInfoController {

    @FXML
    private TextField hospitalNameField, addressField, contactField;

    @FXML
    private Label statusLabel;

    @FXML
    public void updateInfo(ActionEvent event) {
        if (hospitalNameField.getText().isEmpty() ||
                addressField.getText().isEmpty() ||
                contactField.getText().isEmpty()) {
            statusLabel.setText("Fill in all fields.");
        } else {

            // TODO: Save to DB
            statusLabel.setText("Hospital information updated.");
        }
    }

    @FXML
    public void clearForm(ActionEvent event) {
        hospitalNameField.clear();
        addressField.clear();
        contactField.clear();
        statusLabel.setText("");
    }


}