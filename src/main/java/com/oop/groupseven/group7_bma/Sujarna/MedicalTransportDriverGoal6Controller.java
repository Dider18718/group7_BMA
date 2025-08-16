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
public class MedicalTransportDriverGoal6Controller {

    // Defaults keep IntelliJ from warning "never assigned" while FXML still injects at runtime.
    @javafx.fxml.FXML private ComboBox<String> tripStatusComboBox = new ComboBox<>();  // e.g., En Route / Arrived / Completed
    @javafx.fxml.FXML private TextField        locationField      = new TextField();   // current location
    @javafx.fxml.FXML private TextField        passengersField    = new TextField();   // e.g., 1
    @javafx.fxml.FXML private TextField        distanceField      = new TextField();   // km/miles since last update
    @javafx.fxml.FXML private TextArea         notesTextArea      = new TextArea();
    @javafx.fxml.FXML private ListView<String> statusListView     = new ListView<>();
    @javafx.fxml.FXML private Label            statusLabel        = new Label();

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String status = tripStatusComboBox != null ? tripStatusComboBox.getValue() : null;
        String loc    = locationField != null ? locationField.getText() : null;
        Integer pax   = parseInt(passengersField != null ? passengersField.getText() : null, "Passengers");
        Double dist   = parseDouble(distanceField != null ? distanceField.getText() : null, "Distance");
        String notes  = notesTextArea != null ? notesTextArea.getText() : null;

        if (isBlank(status) || isBlank(loc) || pax == null || pax < 0 || dist == null || dist < 0) {
            showError("Missing/invalid data",
                    "Select Trip Status and enter Location, Passengers (≥0), and Distance (≥0).");
            actionEvent.consume();
            return;
        }

        String entry = String.format("[%s] Status=%s, Loc=%s, Pax=%d, Dist=%.2f%s",
                LocalDateTime.now(), status, loc, pax, dist,
                (notes != null && !notes.isBlank()) ? (", Notes=" + notes.trim()) : "");

        if (statusListView != null) {
            statusListView.getItems().add(entry);
            statusListView.scrollTo(statusListView.getItems().size() - 1);
        }
        if (statusLabel != null) statusLabel.setText("Trip status saved: " + status + " @ " + loc);

        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        if (tripStatusComboBox != null) tripStatusComboBox.getSelectionModel().clearSelection();
        if (locationField      != null) locationField.clear();
        if (passengersField    != null) passengersField.clear();
        if (distanceField      != null) distanceField.clear();
        if (notesTextArea      != null) notesTextArea.clear();
        if (statusLabel        != null) statusLabel.setText("Cleared");
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
