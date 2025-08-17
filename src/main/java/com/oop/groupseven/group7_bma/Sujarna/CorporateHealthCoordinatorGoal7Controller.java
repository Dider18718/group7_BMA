package com.oop.groupseven.group7_bma.Sujarna;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
public class CorporateHealthCoordinatorGoal7Controller {

    @javafx.fxml.FXML private ComboBox<String> eventComboBox;
    @javafx.fxml.FXML private TextField attendanceTextField;
    @javafx.fxml.FXML private Label rateLabel;
    @javafx.fxml.FXML private Label employedLabel;

    @javafx.fxml.FXML
    public void initialize() {
        if (eventComboBox != null && eventComboBox.getItems().isEmpty()) {
            eventComboBox.setItems(FXCollections.observableArrayList("CME-001","Camp-2025-01","Camp-2025-02"));
        }
        if (rateLabel != null) rateLabel.setText("");
        if (employedLabel != null) employedLabel.setText("");
    }

    @javafx.fxml.FXML
    public void submitButton(ActionEvent e) {
        String ev = eventComboBox != null ? eventComboBox.getValue() : null;
        if (ev == null) { showWarn("Missing", "Select an event."); return; }

        int attended;
        try { attended = Integer.parseInt(attendanceTextField.getText()); }
        catch (Exception ex) { showWarn("Invalid", "Attendance must be a number."); return; }

        int capacity = 150; // demo capacity
        double rate = capacity > 0 ? (attended * 100.0) / capacity : 0.0;

        if (rateLabel != null) rateLabel.setText(String.format("Rate: %.1f%%", rate));
        if (employedLabel != null) employedLabel.setText("Capacity: " + capacity);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent event) { navigateToDashboard(event); }

    private void navigateToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Sujarna/CorporateHealthCoordinator.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            showError("Navigation Error", ex.getMessage());
        }
    }

    private void showWarn(String header, String message) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Warning");
        a.setHeaderText(header);
        a.setContentText(message);
        a.showAndWait();
    }
    private void showError(String header, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(header);
        a.setContentText(message);
        a.showAndWait();
    }
}
