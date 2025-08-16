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
public class MedicalTransportDriverGoal1Controller {

    // Defaults keep IntelliJ from warning "never assigned" while FXML still injects at runtime.
    @javafx.fxml.FXML private ComboBox<String> patientComboBox = new ComboBox<>();
    @javafx.fxml.FXML private ComboBox<String> routeComboBox   = new ComboBox<>();
    @javafx.fxml.FXML private DatePicker       datePicker      = new DatePicker();
    @javafx.fxml.FXML private TextField        timeField       = new TextField(); // e.g., "10:30 AM"
    @javafx.fxml.FXML private ListView<String> scheduleListView = new ListView<>();
    @javafx.fxml.FXML private Label            statusLabel       = new Label();

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String patient = (patientComboBox != null) ? patientComboBox.getValue() : null;
        String route   = (routeComboBox   != null) ? routeComboBox.getValue()   : null;
        String date    = (datePicker != null && datePicker.getValue() != null)
                ? datePicker.getValue().toString() : null;
        String time    = (timeField != null) ? timeField.getText() : null;

        if (isBlank(patient) || isBlank(route) || isBlank(date) || isBlank(time)) {
            showError("Missing data", "Please select Patient, Route, Date and enter Time.");
            actionEvent.consume();
            return;
        }

        String entry = String.format("[%s] Patient=%s, Route=%s, Date=%s, Time=%s",
                LocalDateTime.now(), patient, route, date, time);

        if (scheduleListView != null) {
            scheduleListView.getItems().add(entry);
            scheduleListView.scrollTo(scheduleListView.getItems().size() - 1);
        }
        if (statusLabel != null) {
            statusLabel.setText("Ride scheduled for " + patient + " (" + date + " " + time + ")");
        }

        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        if (patientComboBox != null) patientComboBox.getSelectionModel().clearSelection();
        if (routeComboBox   != null) routeComboBox.getSelectionModel().clearSelection();
        if (datePicker      != null) datePicker.setValue(null);
        if (timeField       != null) timeField.clear();
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
