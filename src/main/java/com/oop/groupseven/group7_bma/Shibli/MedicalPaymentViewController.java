package com.oop.groupseven.group7_bma.Patient;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for Medical Payment view.
 * Allows patient to pay bills via card or mobile banking.
 */
public class MedicalPaymentViewController {

    @FXML
    private ComboBox<String> paymentMethodCombo;

    @FXML
    private TextField accountNumberField;

    @FXML
    private TextField amountField;

    @FXML
    public void initialize() {
        paymentMethodCombo.setItems(FXCollections.observableArrayList(
                "Credit Card",
                "Debit Card",
                "bKash",
                "Nagad",
                "Rocket"
        ));
    }

    @FXML
    public void processPayment(ActionEvent event) {
        // TODO: Implement payment processing logic
        System.out.println("Payment method: " + paymentMethodCombo.getValue());
        System.out.println("Account: " + accountNumberField.getText());
        System.out.println("Amount: " + amountField.getText());
    }

    @FXML
    public void goBack(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(
                    "/com/oop/groupseven/group7_bma/Patient/PatientDashboardView.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Patient Dashboard");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
