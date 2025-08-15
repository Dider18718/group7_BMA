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
public class MedicalTransportDriverGoal4Controller {

    // Defaults keep IntelliJ from warning "never assigned" while FXML still injects at runtime.
    @javafx.fxml.FXML private ComboBox<String> vehicleComboBox   = new ComboBox<>();
    @javafx.fxml.FXML private ComboBox<String> statusComboBox    = new ComboBox<>(); // e.g., OK / Needs Service / Out of Service
    @javafx.fxml.FXML private DatePicker       inspectionDatePicker = new DatePicker();
    @javafx.fxml.FXML private TextField        odometerField     = new TextField();   // km / miles
    @javafx.fxml.FXML private TextArea         notesTextArea     = new TextArea();
    @javafx.fxml.FXML private ListView<String> vehicleLogListView = new ListView<>();
    @javafx.fxml.FXML private Label            statusLabel       = new Label();

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String vehicle   = vehicleComboBox != null ? vehicleComboBox.getValue() : null;
        String vStatus   = statusComboBox  != null ? statusComboBox.getValue()  : null;
        String date      = (inspectionDatePicker != null && inspectionDatePicker.getValue() != null)
                ? inspectionDatePicker.getValue().toString() : null;
        Integer odo      = parseInt(odometerField != null ? odometerField.getText() : null, "Odometer");
        String notes     = notesTextArea != null ? notesTextArea.getText() : null;

        if (isBlank(vehicle) || isBlank(vStatus) || isBlank(date) || odo == null || odo < 0) {
            showError("Missing/invalid data",
                    "Please select Vehicle, Status, Date and enter a valid Odometer (>= 0).");
            actionEvent.consume();
            return;
        }

        String entry = String.format("[%s] Vehicle=%s, Status=%s, Date=%s, Odo=%,d%s",
                LocalDateTime.now(), vehicle, vStatus, date, odo,
                (notes != null && !notes.isBlank()) ? (", Notes=" + notes.trim()) : "");

        if (vehicleLogListView != null) {
            vehicleLogListView.getItems().add(entry);
            vehicleLogListView.scrollTo(vehicleLogListView.getItems().size() - 1);
        }
        if (statusLabel != null) {
            statusLabel.setText("Vehicle status updated: " + vehicle + " → " + vStatus);
        }

        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        if (vehicleComboBox != null) vehicleComboBox.getSelectionModel().clearSelection();
        if (statusComboBox  != null) statusComboBox.getSelectionModel().clearSelection();
        if (inspectionDatePicker != null) inspectionDatePicker.setValue(null);
        if (odometerField   != null) odometerField.clear();
        if (notesTextArea   != null) notesTextArea.clear();
        if (statusLabel     != null) statusLabel.setText("Cleared");
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
