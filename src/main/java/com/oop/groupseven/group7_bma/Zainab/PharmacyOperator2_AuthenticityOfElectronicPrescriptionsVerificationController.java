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

public class PharmacyOperator2_AuthenticityOfElectronicPrescriptionsVerificationController {
    @javafx.fxml.FXML
    private TextField prescriptionIDTextField;
    @javafx.fxml.FXML
    private Label doctorIDLabel;
    @javafx.fxml.FXML
    private Label digitalSignatureStatusLabel;

    // Mock database of prescriptions (PrescriptionID -> DoctorID)
    private final Map<String, String> mockPrescriptionDatabase = new HashMap<>();
    // Mock signatures (PrescriptionID -> Validity)
    private final Map<String, Boolean> mockSignatureDatabase = new HashMap<>();



    @javafx.fxml.FXML
    public void initialize() {
        // Add some sample prescriptions (simulate DB records)
        mockPrescriptionDatabase.put("RX123", "DOC001");
        mockPrescriptionDatabase.put("RX456", "DOC002");
        mockPrescriptionDatabase.put("RX789", "DOC003");

        mockSignatureDatabase.put("RX123", true);
        mockSignatureDatabase.put("RX456", false); // Tampered
        mockSignatureDatabase.put("RX789", true);
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
    public void flagandAlertAdminButtonOnAction(ActionEvent actionEvent) {
        String prescriptionId = prescriptionIDTextField.getText().trim();

        if (prescriptionId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Missing Input", "Please enter a Prescription ID to flag.");
            return;
        }

        showAlert(Alert.AlertType.ERROR, "Admin Alert",
                "Prescription " + prescriptionId + " has been flagged as potentially fraudulent.\nAdmin has been alerted.");
    }

    @javafx.fxml.FXML
    public void markAsVerifiedButtonOnAction(ActionEvent actionEvent) {
        String prescriptionId = prescriptionIDTextField.getText().trim();

        if (prescriptionId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Missing Input", "Please enter a Prescription ID.");
            return;
        }

        if (!mockPrescriptionDatabase.containsKey(prescriptionId)) {
            showAlert(Alert.AlertType.ERROR, "Invalid Prescription", "Prescription ID not found.");
            return;
        }

        String doctorId = mockPrescriptionDatabase.get(prescriptionId);
        boolean isValid = mockSignatureDatabase.getOrDefault(prescriptionId, false);

        doctorIDLabel.setText("Doctor ID: " + doctorId);
        digitalSignatureStatusLabel.setText(isValid ? "Valid Digital Signature ✅" : "Invalid Digital Signature ❌");

        if (isValid) {
            showAlert(Alert.AlertType.INFORMATION, "Verification Successful",
                    "Prescription " + prescriptionId + " has been verified successfully.");
        } else {
            showAlert(Alert.AlertType.WARNING, "Verification Warning",
                    "Prescription found, but the digital signature is INVALID.");
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
