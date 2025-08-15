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
public class MedicalTransportDriverGoal5Controller {

    // Defaults keep IntelliJ from warning "never assigned" while FXML still injects at runtime.
    @javafx.fxml.FXML private DatePicker       datePicker           = new DatePicker();
    @javafx.fxml.FXML private TextField        startOdometerField   = new TextField(); // e.g., 10234
    @javafx.fxml.FXML private TextField        endOdometerField     = new TextField(); // e.g., 10310
    @javafx.fxml.FXML private TextField        tripsCompletedField  = new TextField(); // e.g., 5
    @javafx.fxml.FXML private TextArea         notesTextArea        = new TextArea();
    @javafx.fxml.FXML private ListView<String> summaryListView      = new ListView<>();
    @javafx.fxml.FXML private Label            statusLabel          = new Label();

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String date = (datePicker != null && datePicker.getValue() != null)
                ? datePicker.getValue().toString() : null;
        Integer odoStart = parseInt(startOdometerField != null ? startOdometerField.getText() : null, "Start Odometer");
        Integer odoEnd   = parseInt(endOdometerField   != null ? endOdometerField.getText()   : null, "End Odometer");
        Integer trips    = parseInt(tripsCompletedField != null ? tripsCompletedField.getText() : null, "Trips Completed");
        String notes     = notesTextArea != null ? notesTextArea.getText() : null;

        if (isBlank(date) || odoStart == null || odoEnd == null || trips == null) {
            showError("Missing/invalid data", "Please select Date and enter valid odometers and trips.");
            actionEvent.consume();
            return;
        }
        if (odoStart < 0 || odoEnd < 0 || odoEnd < odoStart) {
            showError("Invalid odometer", "Odometers must be non-negative and End ≥ Start.");
            actionEvent.consume();
            return;
        }
        if (trips < 0) {
            showError("Invalid trips", "Trips Completed must be ≥ 0.");
            actionEvent.consume();
            return;
        }

        int distance = odoEnd - odoStart;

        String entry = String.format("[%s] Date=%s, Trips=%d, Distance=%d, Odo=%d→%d%s",
                LocalDateTime.now(), date, trips, distance, odoStart, odoEnd,
                (notes != null && !notes.isBlank()) ? (", Notes=" + notes.trim()) : "");

        if (summaryListView != null) {
            summaryListView.getItems().add(entry);
            summaryListView.scrollTo(summaryListView.getItems().size() - 1);
        }
        if (statusLabel != null) {
            statusLabel.setText("End-of-day submitted (" + distance + " distance, " + trips + " trips)");
        }

        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        if (datePicker != null) datePicker.setValue(null);
        if (startOdometerField != null) startOdometerField.clear();
        if (endOdometerField != null) endOdometerField.clear();
        if (tripsCompletedField != null) tripsCompletedField.clear();
        if (notesTextArea != null) notesTextArea.clear();
        if (statusLabel != null) statusLabel.setText("Cleared");
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
