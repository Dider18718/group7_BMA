package com.oop.groupseven.group7_bma.Zainab;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PharmacyOperator3_DispenseMedicinesToPatientsViewController {
    @javafx.fxml.FXML
    private TextField perscriptionIDTextField;
    @javafx.fxml.FXML
    private Label availabilityStatusLabel;
    @javafx.fxml.FXML
    private TextField searchMedicineTextField;


    // Mock medicine stock
    private final Map<String, Integer> medicineStock = new HashMap<>();

    @javafx.fxml.FXML
    public void initialize() {
        // Populate stock
        medicineStock.put("Paracetamol", 50);
        medicineStock.put("Ibuprofen", 30);
        medicineStock.put("Amoxicillin", 10);
        medicineStock.put("Vitamin C", 100);

        availabilityStatusLabel.setText("Check medicine availability...");
    }


    @javafx.fxml.FXML
    public void markAsDispensedButtonOnAction(ActionEvent actionEvent) {
        String prescriptionId = perscriptionIDTextField.getText().trim();
        String med = searchMedicineTextField.getText().trim();

        if (prescriptionId.isEmpty() || med.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Missing Input", "Please enter Prescription ID and Medicine.");
            return;
        }

        if (medicineStock.containsKey(med) && medicineStock.get(med) > 0) {
            medicineStock.put(med, medicineStock.get(med) - 1); // reduce stock
            availabilityStatusLabel.setText("Prescription " + prescriptionId + " dispensed ✅");
            showAlert(Alert.AlertType.INFORMATION, "Dispensed",
                    "Prescription " + prescriptionId + " dispensed successfully.\nRemaining stock of " + med + ": " + medicineStock.get(med));
        } else {
            showAlert(Alert.AlertType.ERROR, "Dispense Error", med + " is not available in stock.");
        }
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
    public void printLabelButtonOnAction(ActionEvent actionEvent) {
        String med = searchMedicineTextField.getText().trim();
        String prescriptionId = perscriptionIDTextField.getText().trim();

        if (med.isEmpty() || prescriptionId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Missing Input", "Please enter Prescription ID and Medicine.");
            return;
        }

        String label = "=== Prescription Label ===\n" +
                "Prescription ID: " + prescriptionId + "\n" +
                "Medicine: " + med + "\n" +
                "Usage: As directed by doctor\n" +
                "==========================";

        showAlert(Alert.AlertType.INFORMATION, "Label Printed", label);
    }

    @javafx.fxml.FXML
    public void collectPackageButtonOnAction(ActionEvent actionEvent) {
        String med = searchMedicineTextField.getText().trim();
        if (med.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Missing Input", "Please enter a medicine to package.");
            return;
        }

        if (medicineStock.containsKey(med) && medicineStock.get(med) > 0) {
            availabilityStatusLabel.setText(med + " packaged and ready ✅");
            showAlert(Alert.AlertType.INFORMATION, "Packaging Complete", med + " has been packaged.");
        } else {
            availabilityStatusLabel.setText(med + " is OUT OF STOCK ❌");
            showAlert(Alert.AlertType.ERROR, "Stock Error", med + " is not available in stock.");
        }
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
