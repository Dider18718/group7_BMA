package com.oop.groupseven.group7_bma.Zainab;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PharmacyOperator5_NotifyOfOutOfStockMedicinesController {
    @javafx.fxml.FXML
    private ComboBox <String>selectDoctorComboBox;
    @javafx.fxml.FXML
    private TextField perscriptionIDTextField;
    @javafx.fxml.FXML
    private TextArea messageTextArea;
    @javafx.fxml.FXML
    private TextField suggestedAlternativeTextField;

    @javafx.fxml.FXML
    public void initialize() {
        // Mock doctor list (can later be fetched from DB)
        selectDoctorComboBox.getItems().addAll("Dr. Zainab", "Dr. Ahmed", "Dr. Sara", "Dr. John");
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Zainab/pharmacyOperatorDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Pharmacy Operator Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void sendNotificationButtonOnAction(ActionEvent actionEvent) {
        String prescriptionId = perscriptionIDTextField.getText().trim();
        String doctor = selectDoctorComboBox.getValue();
        String message = messageTextArea.getText().trim();
        String alternative = suggestedAlternativeTextField.getText().trim();

        if (prescriptionId.isEmpty() || doctor == null || message.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Missing Input", "Please fill in all required fields (Prescription ID, Doctor, and Message).");
            return;
        }

        // Simulate sending notification
        String notification = "Notification Sent to " + doctor + "\n"
                + "Prescription ID: " + prescriptionId + "\n"
                + "Message: " + message + "\n"
                + "Suggested Alternative: " + (alternative.isEmpty() ? "None" : alternative);

        showAlert(Alert.AlertType.INFORMATION, "Notification Sent", notification);

        // Clear form after sending
        perscriptionIDTextField.clear();
        messageTextArea.clear();
        suggestedAlternativeTextField.clear();
        selectDoctorComboBox.getSelectionModel().clearSelection();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    PharmacyOperatorDashboardController PharmacyOperatorDashboardController ;

    public void setter(TextArea pharmacyOperatorTextArea) { this.PharmacyOperatorDashboardController = PharmacyOperatorDashboardController ;
    }
}
