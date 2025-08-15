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

public class MedicalTransportDriverGoal5Controller {

    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private ComboBox<String> vehicleComboBox;
    @javafx.fxml.FXML
    private TextField stationTextField;
    @javafx.fxml.FXML
    private TextField literTextField;
    @javafx.fxml.FXML
    private Label uploadLabel;

    @javafx.fxml.FXML
    public void uploadButton(ActionEvent actionEvent) {
        // Placeholder: mark the "bill" as uploaded
        if (uploadLabel != null) {
            uploadLabel.setText("Bill attached");
        }
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String vehicle = vehicleComboBox != null ? vehicleComboBox.getValue() : null;
        String station = stationTextField != null ? stationTextField.getText() : null;
        String liters  = literTextField  != null ? literTextField.getText()  : null;
        boolean hasBill = uploadLabel != null && uploadLabel.getText() != null && !uploadLabel.getText().isBlank();

        if (confirmationLabel != null) {
            String msg = "End-of-day refuel submitted"
                    + (vehicle != null ? " • vehicle=" + vehicle : "")
                    + (station != null && !station.isBlank() ? " • station=" + station : "")
                    + (liters != null && !liters.isBlank() ? " • liters=" + liters : "")
                    + (hasBill ? " • bill attached" : "");
            confirmationLabel.setText(msg);
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
