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
public class CorporateHealthCoordinatorGoal2Controller {

    @javafx.fxml.FXML private ComboBox<String> staffComboBox;
    @javafx.fxml.FXML private ComboBox<String> roleComboBox;
    @javafx.fxml.FXML private ComboBox<String> eventComboBox;
    @javafx.fxml.FXML private ListView<String> assignedListView;
    @javafx.fxml.FXML private Label confirmationLabel;

    @javafx.fxml.FXML
    public void assignButton(ActionEvent actionEvent) {
        String staff = (staffComboBox != null) ? staffComboBox.getValue() : null;
        String role  = (roleComboBox  != null) ? roleComboBox.getValue()  : null;
        String event = (eventComboBox != null) ? eventComboBox.getValue() : null;

        if (staff == null || role == null || event == null) {
            showError("Missing selection", "Please choose Staff, Role, and Event before assigning.");
            actionEvent.consume();
            return;
        }

        String summary = String.format("Assigned: staff=%s, role=%s, event=%s", staff, role, event);
        if (assignedListView != null) {
            assignedListView.getItems().add(summary);
        }
        if (confirmationLabel != null) {
            confirmationLabel.setText(summary);
        }
        actionEvent.consume(); // mark param as used
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        navigateToDashboard(actionEvent);
    }

    private void navigateToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    HelloApplication.class.getResource("Sujarna/CorporateHealthCoordinator.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            showError("Navigation Error", e.getMessage());
        }
    }

    private void showError(String header, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(header);
        a.setContentText(message);
        a.showAndWait();
    }
}
