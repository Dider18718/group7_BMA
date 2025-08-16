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
public class CorporateHealthCoordinatorGoal5Controller {

    @javafx.fxml.FXML private ComboBox<String> companyComboBox = new ComboBox<>();
    @javafx.fxml.FXML private ComboBox<String> topicComboBox   = new ComboBox<>();
    @javafx.fxml.FXML private TextArea         queryTextArea    = new TextArea();
    @javafx.fxml.FXML private ListView<String> queriesListView  = new ListView<>();
    @javafx.fxml.FXML private Label            statusLabel      = new Label();

    // ===== Compatibility handlers for FXML onAction="#<fx:id>" =====
    @javafx.fxml.FXML public void companyComboBox(ActionEvent e) { e.consume(); }
    @javafx.fxml.FXML public void topicComboBox(ActionEvent e)   { e.consume(); }
    // ===============================================================

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String company = companyComboBox != null ? companyComboBox.getValue() : null;
        String topic   = topicComboBox   != null ? topicComboBox.getValue()   : null;
        String query   = queryTextArea   != null ? queryTextArea.getText()    : null;

        if (isBlank(company) || isBlank(topic) || isBlank(query)) {
            showError("Missing data", "Please select a Company, a Topic, and enter a Query.");
            actionEvent.consume(); return;
        }

        String item = "[" + LocalDateTime.now() + "] Company=" + company + ", Topic=" + topic + ", Query=" + query;
        if (queriesListView != null) {
            queriesListView.getItems().add(item);
            queriesListView.scrollTo(queriesListView.getItems().size() - 1);
        }
        if (statusLabel != null) statusLabel.setText("Query submitted for " + company + " (topic: " + topic + ")");
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void clearButton(ActionEvent actionEvent) {
        if (queryTextArea != null) queryTextArea.clear();
        if (topicComboBox != null) topicComboBox.getSelectionModel().clearSelection();
        if (companyComboBox != null) companyComboBox.getSelectionModel().clearSelection();
        if (statusLabel != null) statusLabel.setText("Cleared");
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        navigateToDashboard(actionEvent);
    }

    private boolean isBlank(String s) { return s == null || s.trim().isEmpty(); }

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
