package com.oop.groupseven.group7_bma.Sujarna;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDateTime;

@SuppressWarnings({ "SpellCheckingInspection", "CanBeFinal" })
public class MedicalTransportDriverGoal2Controller {

    // Defaults keep IntelliJ from warning "never assigned" while FXML still injects at runtime.
    @javafx.fxml.FXML private ComboBox<String> stationComboBox   = new ComboBox<>();
    @javafx.fxml.FXML private ComboBox<String> fuelTypeComboBox  = new ComboBox<>();
    @javafx.fxml.FXML private TextField        amountField       = new TextField();   // liters
    @javafx.fxml.FXML private TextField        odometerField     = new TextField();   // km / miles
    @javafx.fxml.FXML private ComboBox<String> paymentComboBox   = new ComboBox<>();
    @javafx.fxml.FXML private TextArea         notesTextArea     = new TextArea();
    @javafx.fxml.FXML private ListView<String> refuelListView    = new ListView<>();
    @javafx.fxml.FXML private Label            statusLabel       = new Label();

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String station  = stationComboBox  != null ? stationComboBox.getValue()  : null;
        String fuelType = fuelTypeComboBox != null ? fuelTypeComboBox.getValue() : null;
        Double liters   = parseDouble(amountField != null ? amountField.getText() : null, "Amount (liters)");
        Integer odo     = parseInt(odometerField != null ? odometerField.getText() : null, "Odometer");
        String payment  = paymentComboBox  != null ? paymentComboBox.getValue()  : null;
        String notes    = notesTextArea    != null ? notesTextArea.getText()     : null;

        if (isBlank(station) || isBlank(fuelType) || liters == null || liters <= 0
                || odo == null || odo < 0 || isBlank(payment)) {
            showError("Missing/invalid data",
                    "Please select Station, Fuel Type, Payment and enter valid Amount (>0) and Odometer (>=0).");
            actionEvent.consume();
            return;
        }

        String entry = String.format("[%s] Station=%s, Fuel=%s, Amount=%.2f L, Odo=%d, Pay=%s%s",
                LocalDateTime.now(), station, fuelType, liters, odo, payment,
                (notes != null && !notes.isBlank()) ? (", Notes=" + notes.trim()) : "");

        if (refuelListView != null) {
            refuelListView.getItems().add(entry);
            refuelListView.scrollTo(refuelListView.getItems().size() - 1);
        }
        if (statusLabel != null) {
            statusLabel.setText("Refuel request sent (" + liters + " L @ " + station + ")");
        }

        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        if (stationComboBox  != null) stationComboBox.getSelectionModel().clearSelection();
        if (fuelTypeComboBox != null) fuelTypeComboBox.getSelectionModel().clearSelection();
        if (paymentComboBox  != null) paymentComboBox.getSelectionModel().clearSelection();
        if (amountField      != null) amountField.clear();
        if (odometerField    != null) odometerField.clear();
        if (notesTextArea    != null) notesTextArea.clear();
        if (statusLabel      != null) statusLabel.setText("Cleared");
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        navigateToDashboard(actionEvent);
    }

    // ---------- helpers ----------

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    private Double parseDouble(String s, String fieldName) {
        if (isBlank(s)) {
            showError("Missing value", fieldName + " is required.");
            return null;
        }
        try {
            return Double.parseDouble(s.trim());
        } catch (NumberFormatException e) {
            showError("Invalid number", fieldName + " must be a number.");
            return null;
        }
    }

    private Integer parseInt(String s, String fieldName) {
        if (isBlank(s)) {
            showError("Missing value", fieldName + " is required.");
            return null;
        }
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            showError("Invalid number", fieldName + " must be an integer.");
            return null;
        }
    }

    private void showError(String header, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(header);
        a.setContentText(message);
        a.showAndWait();
    }

    private void navigateToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader =
                    new FXMLLoader(HelloApplication.class.getResource("Sujarna/MedicalTransportDriverDashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showError("Navigation Error", e.getMessage());
        }
    }
}
