package com.oop.groupseven.group7_bma.Sujarna;

import com.oop.groupseven.group7_bma.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
public class CorporateHealthCoordinatorGoal5Controller {

    @javafx.fxml.FXML private ListView<String> queryListView;
    @javafx.fxml.FXML private TextArea replyTextArea;
    @javafx.fxml.FXML private Label replyStatusLabel;

    @javafx.fxml.FXML
    public void initialize() {
        if (queryListView != null && queryListView.getItems().isEmpty()) {
            queryListView.getItems().addAll(
                    "Q-101: Invoice detail request",
                    "Q-102: Next camp date?",
                    "Q-103: Package discount?"
            );
        }
    }

    // FXML names show 'addEditButton' as the handler; we keep it
    @javafx.fxml.FXML
    public void addEditButton(ActionEvent e) {
        String q = (queryListView != null) ? queryListView.getSelectionModel().getSelectedItem() : null;
        String reply = (replyTextArea != null) ? replyTextArea.getText() : null;

        if (q == null || reply == null || reply.isBlank()) {
            showWarn("Missing", "Select a query and write a reply.");
            return;
        }
        if (replyStatusLabel != null) replyStatusLabel.setText("✔ Reply sent for " + q);
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
