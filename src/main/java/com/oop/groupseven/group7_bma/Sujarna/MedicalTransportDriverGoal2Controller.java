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

public class MedicalTransportDriverGoal2Controller {

    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private ComboBox<String> rideComboBox;
    @javafx.fxml.FXML
    private TextArea remarkTextField;

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String ride   = rideComboBox != null ? rideComboBox.getValue() : null;
        String remark = remarkTextField != null ? remarkTextField.getText() : null;

        if (confirmationLabel != null) {
            confirmationLabel.setText("Refuel request submitted: ride=" + ride +
                    (remark != null && !remark.isBlank() ? (", remark=" + remark) : ""));
        }

        // Mark handled
        actionEvent.consume();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        navigateToDashboard(actionEvent);
    }

    @SuppressWarnings("SpellCheckingInspection")
    private static final String BASE = "/com/oop/groupseven/group7_bma/Sujarna/";

    private void navigateToDashboard(ActionEvent event) {
        // Inline null-safe navigation
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
