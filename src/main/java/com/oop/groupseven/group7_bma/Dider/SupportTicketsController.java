package com.oop.groupseven.group7_bma.Dider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class SupportTicketsController {

    @FXML private TextArea queryArea, responseArea;
    @FXML private Label statusLabel;

    @FXML
    public void sendResponse(ActionEvent event) {
        if (queryArea.getText().isEmpty() || responseArea.getText().isEmpty()) {
            statusLabel.setText("Both fields are required.");
        } else {
            // TODO: Save response in DB
            statusLabel.setText("Response sent to patient.");
        }
    }

    @FXML
    public void clearForm(ActionEvent event) {

        queryArea.clear();
        responseArea.clear();
        statusLabel.setText("");
    }


}