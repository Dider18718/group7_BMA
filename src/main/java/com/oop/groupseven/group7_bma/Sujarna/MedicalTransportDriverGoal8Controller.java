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
public class MedicalTransportDriverGoal8Controller {

    // Defaults keep IntelliJ from warning "never assigned" while FXML still injects at runtime.
    @javafx.fxml.FXML private ComboBox<String> priorityComboBox    = new ComboBox<>(); // Low/Medium/High/Critical
    @javafx.fxml.FXML private TextField        currentLocationField = new TextField();
    @javafx.fxml.FXML private TextField        destinationField     = new TextField();
    @javafx.fxml.FXML private TextField        patientField         = new TextField(); // optional
    @javafx.fxml.FXML private TextArea         detailsTextArea      = new TextArea();
    @javafx.fxml.FXML private ListView<String> emergencyListView    = new ListView<>();
    @javafx.fxml.FXML private Label            statusLabel          = new Label();

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String priority = priorityComboBox != null ? priorityComboBox.getValue() : null;
        String from     = currentLocationField != null ? currentLocationField.getText() : null;
        String to       = destinationField != null ? destinationField.getText() : null;
        String patient  = patientField != null ? patientField.getText() : null;
        String details  = detailsTextArea != null ? detailsTextArea.getText() : null;

        if (isBlank(priority) || isBlank(to)) {
            showError("Missing data", "Please select Priority and enter Destination.");
            actionEvent.consume();
            return;
        }

        String entry = String.format("[%s] Priority=%s, From=%s, To=%s%s%s",
                LocalDateTime.now(),
                priority,
                !isBlank(from) ? from.trim() : "?",
                to.trim(),
                !isBlank(patient) ? (", Patient=" + patient.trim()) : "",
                !isBlank(details) ? (", Details=" + details.trim()) : "");

        if (emergencyListView != null) {
            emergencyListView.getItems().add(entry);
            emergencyListView.scrollTo(emergencyListView.getItems().size() - 1);
        }
        if (statusLabel != null) statusLabel.setText("Emergency route requested → " + to + " (" + priority + ")");

        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        if (priorityComboBox    != null) priorityComboBox.getSelectionModel().clearSelection();
        if (currentLocationField != null) currentLocationField.clear();
        if (destinationField    != null) destinationField.clear();
        if (patientField        != null) patientField.clear();
        if (detailsTextArea     != null) detailsTextArea.clear();
        if (statusLabel         != null) statusLabel.setText("Cleared");
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
