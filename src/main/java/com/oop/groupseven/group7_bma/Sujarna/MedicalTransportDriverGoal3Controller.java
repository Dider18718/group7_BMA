package com.oop.groupseven.group7_bma.Sujarna;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
public class MedicalTransportDriverGoal3Controller {

    @javafx.fxml.FXML
    public void submitButton(ActionEvent event) {
        event.consume();
        showInfo("Issue Report", "Vehicle issue submitted to the admin.");
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent event) {
        navigateToDashboard(event);
    }

    private void navigateToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Sujarna/MedicalTransportDriverDashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showError("Navigation Error", e.getMessage());
        }
    }

    @SuppressWarnings("SameParameterValue")
    private void showInfo(String header, String message) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Info");
        a.setHeaderText(header);
        a.setContentText(message);
        a.show();
    }

    @SuppressWarnings("SameParameterValue")
    private void showError(String header, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(header);
        a.setContentText(message);
        a.showAndWait();
    }
}
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
public class MedicalTransportDriverGoal3Controller {

    // Defaults keep IntelliJ from warning "never assigned" while FXML still injects at runtime.
    @javafx.fxml.FXML private ComboBox<String> routeComboBox      = new ComboBox<>();
    @javafx.fxml.FXML private TextField        currentLocationField = new TextField();
    @javafx.fxml.FXML private TextField        destinationField     = new TextField();
    @javafx.fxml.FXML private TextArea         issueTextArea        = new TextArea();
    @javafx.fxml.FXML private ListView<String> updatesListView      = new ListView<>();
    @javafx.fxml.FXML private Label            statusLabel          = new Label();

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String route    = routeComboBox != null ? routeComboBox.getValue() : null;
        String current  = currentLocationField != null ? currentLocationField.getText() : null;
        String dest     = destinationField != null ? destinationField.getText() : null;
        String issue    = issueTextArea != null ? issueTextArea.getText() : null;

        if ((isBlank(route) && (isBlank(current) || isBlank(dest))) && isBlank(issue)) {
            showError("Missing data", "Provide Route, or Current+Destination, or an Issue to report.");
            actionEvent.consume();
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(LocalDateTime.now()).append("] ");
        if (!isBlank(route)) sb.append("Route=").append(route).append("; ");
        if (!isBlank(current) || !isBlank(dest)) {
            sb.append("From=").append(isBlank(current) ? "?" : current)
                    .append(" -> To=").append(isBlank(dest) ? "?" : dest).append("; ");
        }
        if (!isBlank(issue)) sb.append("Issue=").append(issue.trim());

        String entry = sb.toString().trim();

        if (updatesListView != null) {
            updatesListView.getItems().add(entry);
            updatesListView.scrollTo(updatesListView.getItems().size() - 1);
        }
        if (statusLabel != null) statusLabel.setText("Route checked / issue noted");

        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        if (routeComboBox != null) routeComboBox.getSelectionModel().clearSelection();
        if (currentLocationField != null) currentLocationField.clear();
        if (destinationField != null) destinationField.clear();
        if (issueTextArea != null) issueTextArea.clear();
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
