package com.oop.groupseven.group7_bma.Sujarna;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class CorporateHealthCoordinatorGoal5Controller {

    @javafx.fxml.FXML
    private ListView<String> queryListView;
    @javafx.fxml.FXML
    private Label queryLabel;
    @javafx.fxml.FXML
    private TextArea responseTextArea;
    @javafx.fxml.FXML
    private Label replyStatusLabel;

    @javafx.fxml.FXML
    public void addEditButton(ActionEvent actionEvent) {
        String selectedQuery = (queryListView != null) ? queryListView.getSelectionModel().getSelectedItem() : null;
        String response = (responseTextArea != null) ? responseTextArea.getText() : null;

        if (queryLabel != null) {
            queryLabel.setText("Query Details: " + selectedQuery);
        }
        if (replyStatusLabel != null) {
            replyStatusLabel.setText((response != null && !response.isBlank()) ? "Response saved" : "No response");
        }
        // Optionally reflect the response back into the list for a visible change
        if (queryListView != null && selectedQuery != null && response != null && !response.isBlank()) {
            queryListView.getItems().add("Replied to: " + selectedQuery);
        }
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        navigateToDashboard(actionEvent);
    }

    @SuppressWarnings("SpellCheckingInspection")
    private static final String BASE = "/com/oop/groupseven/group7_bma/Sujarna/";

    private void navigateToDashboard(ActionEvent event) {
        URL url = this.getClass().getResource(BASE + "CorporateHealthCoordinator.fxml");
        if (url == null) {
            showError("Missing FXML",
                    "Could not find resource: " + BASE + "CorporateHealthCoordinator.fxml" + System.lineSeparator()
                            + "Make sure it is on the runtime classpath under src/main/resources");
            return;
        }
        try {
            Parent root = FXMLLoader.load(url);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showError("Navigation Error", e.getMessage());
        }
    }

    private void showError(String header, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
