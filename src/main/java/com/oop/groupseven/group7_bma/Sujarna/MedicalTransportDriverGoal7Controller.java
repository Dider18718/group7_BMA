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
public class MedicalTransportDriverGoal7Controller {

    // Defaults keep IntelliJ from warning "never assigned" while FXML still injects at runtime.
    @javafx.fxml.FXML private ComboBox<String> issueTypeComboBox   = new ComboBox<>(); // e.g., Traffic / Breakdown / Delay
    @javafx.fxml.FXML private ComboBox<String> severityComboBox    = new ComboBox<>(); // e.g., Low / Medium / High
    @javafx.fxml.FXML private TextField        locationField       = new TextField();
    @javafx.fxml.FXML private TextArea         descriptionTextArea = new TextArea();
    @javafx.fxml.FXML private ListView<String> issuesListView      = new ListView<>();
    @javafx.fxml.FXML private Label            statusLabel         = new Label();

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String type   = issueTypeComboBox != null ? issueTypeComboBox.getValue() : null;
        String sev    = severityComboBox  != null ? severityComboBox.getValue()  : null;
        String loc    = locationField     != null ? locationField.getText()      : null;
        String desc   = descriptionTextArea != null ? descriptionTextArea.getText() : null;

        if (isBlank(type) || isBlank(sev) || isBlank(desc)) {
            showError("Missing data", "Please select Issue Type, Severity and enter a Description.");
            actionEvent.consume();
            return;
        }

        String entry = String.format("[%s] Type=%s, Severity=%s%s, Desc=%s",
                LocalDateTime.now(),
                type,
                sev,
                (!isBlank(loc) ? (", Location=" + loc.trim()) : ""),
                desc.trim());

        if (issuesListView != null) {
            issuesListView.getItems().add(entry);
            issuesListView.scrollTo(issuesListView.getItems().size() - 1);
        }
        if (statusLabel != null) statusLabel.setText("Incident reported: " + type + " (" + sev + ")");

        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        if (issueTypeComboBox   != null) issueTypeComboBox.getSelectionModel().clearSelection();
        if (severityComboBox    != null) severityComboBox.getSelectionModel().clearSelection();
        if (locationField       != null) locationField.clear();
        if (descriptionTextArea != null) descriptionTextArea.clear();
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
