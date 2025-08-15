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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MedicalTransportDriverGoal4Controller {

    @javafx.fxml.FXML
    private Label requestCodeLabel;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TextField reasonTextField;
    @javafx.fxml.FXML
    private TextField locationTextField;

    @javafx.fxml.FXML
    public void requestButton(ActionEvent actionEvent) {
        String reason = reasonTextField != null ? reasonTextField.getText() : null;
        String loc    = locationTextField != null ? locationTextField.getText() : null;

        boolean ok = reason != null && !reason.isBlank() && loc != null && !loc.isBlank();

        if (!ok) {
            if (errorLabel != null) {
                errorLabel.setDisable(false);
                errorLabel.setText("Please enter both Location and Reason");
            }
            actionEvent.consume();
            return;
        }

        if (errorLabel != null) {
            errorLabel.setDisable(false);
            errorLabel.setText("Emergency route requested");
        }

        if (requestCodeLabel != null) {
            String code = "REQ-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMddHHmmss"));
            requestCodeLabel.setText("Request Code: " + code);
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
        URL url = this.getClass().getResource(BASE + "MedicalTransportDriverDashboard.fxml");
        if (url == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Missing FXML");
            a.setContentText("Could not find resource: " + BASE + "MedicalTransportDriverDashboard.fxml" + System.lineSeparator()
                    + "Make sure it is on the classpath under src/main/resources");
            a.showAndWait();
            return;
        }
        try {
            Parent root = FXMLLoader.load(url);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Navigation Error");
            a.setContentText(e.getMessage());
            a.showAndWait();
        }
    }
}
