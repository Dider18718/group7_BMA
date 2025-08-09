package com.oop.groupseven.group7_bma.Shibli;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import java.awt.*;

public class MedicalPaymentViewController
{
    @javafx.fxml.FXML
    private ComboBox paymentMethodCombo;
    @javafx.fxml.FXML
    private Label billAmountLabel;
    @javafx.fxml.FXML
    private TextField expiryDateField;
    @javafx.fxml.FXML
    private PasswordField cvvField;
    @javafx.fxml.FXML
    private TextField accountNumberField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handlePay(ActionEvent actionEvent) {
    }
}