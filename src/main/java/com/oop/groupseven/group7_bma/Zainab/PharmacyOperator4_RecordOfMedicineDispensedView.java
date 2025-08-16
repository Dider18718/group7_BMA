package com.oop.groupseven.group7_bma.Zainab;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PharmacyOperator4_RecordOfMedicineDispensedView {
    @javafx.fxml.FXML
    private TextField prescriptionIDTextField;
    @javafx.fxml.FXML
    private TextField scanBarcodeTextField;
    @javafx.fxml.FXML
    private TextField patientNameTextField;
    @javafx.fxml.FXML
    private TextField quantityTextField;

    // Mock in-memory record storage
    private static final List<String> dispenseRecords = new ArrayList<>();


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
    public void saveEntryButtonOnAction(ActionEvent actionEvent) {
        String barcode = scanBarcodeTextField.getText().trim();
        String prescriptionId = prescriptionIDTextField.getText().trim();
        String patientName = patientNameTextField.getText().trim();
        String quantity = quantityTextField.getText().trim();

        if (barcode.isEmpty() || prescriptionId.isEmpty() || patientName.isEmpty() || quantity.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Missing Input", "Please fill in all fields before saving.");
            return;
        }

        // Save record (later can be saved to DB instead of memory)
        String record = "PrescriptionID: " + prescriptionId +
                ", Barcode: " + barcode +
                ", Patient: " + patientName +
                ", Quantity: " + quantity;
        dispenseRecords.add(record);

        showAlert(Alert.AlertType.INFORMATION, "Entry Saved", "Dispense record saved successfully:\n" + record);

        // Clear form after saving
        scanBarcodeTextField.clear();
        prescriptionIDTextField.clear();
        patientNameTextField.clear();
        quantityTextField.clear();
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

    // Getter for records (for future use in reporting / history view)
    public static List<String> getDispenseRecords() {
        return dispenseRecords;
    }
}
