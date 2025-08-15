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
public class CorporateHealthCoordinatorGoal7Controller {

    @javafx.fxml.FXML private ComboBox<String> eventComboBox = new ComboBox<>();
    @javafx.fxml.FXML private TextField attendanceField = new TextField();
    @javafx.fxml.FXML private TextField employedField   = new TextField();
    @javafx.fxml.FXML private ProgressBar participationBar = new ProgressBar(0.0);
    @javafx.fxml.FXML private Label resultLabel = new Label();
    @javafx.fxml.FXML private ListView<String> historyListView = new ListView<>();

    // ===== Compatibility handler for FXML onAction="#eventComboBox" =====
    @javafx.fxml.FXML public void eventComboBox(ActionEvent e) { e.consume(); }
    // ====================================================================

    @javafx.fxml.FXML
    public void calculateButton(ActionEvent actionEvent) {
        String event = eventComboBox != null ? eventComboBox.getValue() : null;
        Integer attended = parseInt(attendanceField.getText(), "Attendance");
        Integer employed = parseInt(employedField.getText(), "Total Employed");

        if (attended == null || employed == null) { actionEvent.consume(); return; }
        if (employed <= 0) { showError("Invalid input", "Total Employed must be greater than 0."); actionEvent.consume(); return; }
        if (attended < 0 || attended > employed) { showError("Invalid input", "Attendance must be between 0 and Total Employed."); actionEvent.consume(); return; }

        double rate = (attended * 100.0) / employed;
        double progress = Math.max(0.0, Math.min(1.0, rate / 100.0));
        if (participationBar != null) participationBar.setProgress(progress);

        String labelText = String.format("Participation: %.2f%%  (%,d / %,d)%s",
                rate, attended, employed, event != null ? "  |  Event: " + event : "");
        if (resultLabel != null) resultLabel.setText(labelText);

        if (historyListView != null) {
            String item = String.format("[%s] %s", LocalDateTime.now(), labelText);
            historyListView.getItems().add(item);
            historyListView.scrollTo(historyListView.getItems().size() - 1);
        }
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        if (attendanceField != null) attendanceField.clear();
        if (employedField   != null) employedField.clear();
        if (participationBar != null) participationBar.setProgress(0.0);
        if (resultLabel != null) resultLabel.setText("Cleared");
        if (eventComboBox != null) eventComboBox.getSelectionModel().clearSelection();
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) { navigateToDashboard(actionEvent); }

    private Integer parseInt(String s, String field) {
        if (s == null || s.trim().isEmpty()) { showError("Missing value", field + " is required."); return null; }
        try { return Integer.parseInt(s.trim()); }
        catch (NumberFormatException e) { showError("Invalid number", field + " must be an integer."); return null; }
    }

    private void showError(String header, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error"); a.setHeaderText(header); a.setContentText(message); a.showAndWait();
    }

    private void navigateToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader =
                    new FXMLLoader(HelloApplication.class.getResource("Sujarna/CorporateHealthCoordinator.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root)); stage.show();
        } catch (IOException e) { showError("Navigation Error", e.getMessage()); }
    }
}
