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
public class CorporateHealthCoordinatorGoal3Controller {

    @javafx.fxml.FXML private ComboBox<String> companyComboBox;
    @javafx.fxml.FXML private ComboBox<String> eventComboBox;
    @javafx.fxml.FXML private Label uploadStatusLabel;
    @javafx.fxml.FXML private Label confirmationLabel;

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String company = (companyComboBox != null) ? companyComboBox.getValue() : null;
        String event   = (eventComboBox   != null) ? eventComboBox.getValue()   : null;

        if (company == null || event == null) {
            showError("Missing selection", "Please choose both Company and Event before submitting.");
            actionEvent.consume();
            return;
        }

        String summary = String.format("Submitted: company=%s, event=%s", company, event);
        if (confirmationLabel != null) {
            confirmationLabel.setText(summary);
        }
        actionEvent.consume(); // mark param as used
    }

    @javafx.fxml.FXML
    public void attachButton(ActionEvent actionEvent) {
        if (uploadStatusLabel != null) {
            uploadStatusLabel.setText("Attachment added");
        }
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        navigateToDashboard(actionEvent);
    }

    private void navigateToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader =
                    new FXMLLoader(HelloApplication.class.getResource("Sujarna/CorporateHealthCoordinator.fxml"));
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

