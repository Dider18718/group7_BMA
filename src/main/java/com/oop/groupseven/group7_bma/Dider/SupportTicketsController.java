package com.oop.groupseven.group7_bma.Dider;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SupportTicketsController {
    @FXML private TextField ticketIdField, replyField;
    @FXML private TextArea questionArea;
    @FXML private Label statusLabel;

    @FXML private void sendReply() {
        if (ticketIdField.getText().isEmpty() || replyField.getText().isEmpty()) {
            statusLabel.setText("Ticket ID and reply required.");
        } else {
            statusLabel.setText("Reply sent for ticket #" + ticketIdField.getText());
        }
    }
}